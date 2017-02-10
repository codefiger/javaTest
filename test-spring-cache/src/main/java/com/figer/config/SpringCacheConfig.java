package com.figer.config;

import com.figer.InnerInvocationableProductService;
import com.figer.springframent.InjectBeanSelfProcessor;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.LoadTimeWeavingConfigurer;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.instrument.classloading.ReflectiveLoadTimeWeaver;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by figer on 8/24/16.
 */
@Configuration
@ComponentScan(basePackageClasses = {InnerInvocationableProductService.class, InjectBeanSelfProcessor.class})
@EnableCaching
@EnableAspectJAutoProxy(exposeProxy = true)
public class SpringCacheConfig implements LoadTimeWeavingConfigurer {
  public static final long DEFAULT_EXPIRE_TIME = 60;
  public static final TimeUnit DEFAULT_TIME_UNIT = TimeUnit.SECONDS;
  public static final long DEFAULT_MAXSIZE = 2000;

  @Override
  public LoadTimeWeaver getLoadTimeWeaver() {
    return new ReflectiveLoadTimeWeaver();
  }

  /**
   * set cache name,expire time and maxSize
   */
  public enum CacheConfig {
    productCache(10, TimeUnit.SECONDS, 100),
    another(40, TimeUnit.SECONDS, 100),
    ;
    private long expireTime = DEFAULT_EXPIRE_TIME;
    private TimeUnit timeUnit = DEFAULT_TIME_UNIT;
    private long maxSize = DEFAULT_MAXSIZE;

    /**
     * use default params
     */
    CacheConfig(){}

    CacheConfig(long expireTime){
      this.expireTime = expireTime;
    }

    CacheConfig(long expireTime, TimeUnit timeUnit){
      this.expireTime = expireTime;
      this.timeUnit = timeUnit;
    }

    CacheConfig(long expireTime, TimeUnit timeUnit, long maxSize){
      this.expireTime = expireTime;
      this.timeUnit = timeUnit;
      this.maxSize = maxSize;
    }

    public long getExpireTime() {
      return expireTime;
    }

    public TimeUnit getTimeUnit() {
      return timeUnit;
    }

    public long getMaxSize() {
      return maxSize;
    }
  }

  /*@Bean
  public CacheManager guavaCacheManager() {
    SimpleCacheManager cacheManager = new SimpleCacheManager();

    List<Cache> caches = new ArrayList<Cache>();
    for(CacheConstant c : CacheConstant.values()){
      caches.add(new ConcurrentMapCache(c.name()));
    }
    cacheManager.setCaches(caches);
    return cacheManager;
  }*/

  //redis start
  /*
   * redis.cluster.nodes[0] = 127.0.0.1:7379
   * redis.cluster.nodes[1] = 127.0.0.1:7380
   * ...
   */
  //@Value("redis.cluster")
  private static final List<String> nodes = Lists.newArrayList("localhost:6379");

  public @Bean JedisConnectionFactory redisConnectionFactory() {
    //JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory(new RedisClusterConfiguration(nodes));
    JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory();
    redisConnectionFactory.setHostName("localhost");
    redisConnectionFactory.setPort(6379);
    return redisConnectionFactory;
  }

  public @Bean StringRedisSerializer stringRedisSerializer(){
    return new StringRedisSerializer();
  }

  public @Bean RedisTemplate<String, String> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
    RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(redisConnectionFactory);
    redisTemplate.setKeySerializer(stringRedisSerializer());
    redisTemplate.setHashKeySerializer(stringRedisSerializer());
    return redisTemplate;
  }

  public @Primary@Bean CacheManager cacheManager(RedisTemplate redisTemplate) {
    //GuavaCacheManager --->  RedisCacheManager
    RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
    List<String> cacheNames = new ArrayList<>();
    Map<String, Long> expires = Maps.newConcurrentMap();
    for(CacheConfig cacheConfig : CacheConfig.values()){
      cacheNames.add(cacheConfig.name());
      expires.put(cacheConfig.name(), cacheConfig.expireTime);
    }
    cacheManager.setExpires(expires);
    cacheManager.setCacheNames(cacheNames);
    cacheManager.setUsePrefix(true);
    return cacheManager;
  }

  @Bean
  public KeyGenerator customKeyGenerator() {
    return new KeyGenerator() {
      @Override
      public Object generate(Object target, Method method, Object... params) {
        StringBuilder sb = new StringBuilder();
        sb.append(target.getClass().getName());
        sb.append(method.getName());
        for (Object obj : params) {
          sb.append(obj.toString());
        }
        return sb.toString();
      }
    };
  }


  //redis end

}
