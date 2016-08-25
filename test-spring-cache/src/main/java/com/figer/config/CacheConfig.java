package com.figer.config;

import com.figer.InnerInvocationableProductService;
import com.figer.springframent.InjectBeanSelfProcessor;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.LoadTimeWeavingConfigurer;
import org.springframework.context.annotation.Primary;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.instrument.classloading.ReflectiveLoadTimeWeaver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by figer on 8/24/16.
 */
@Configuration
@ComponentScan(basePackageClasses = {InnerInvocationableProductService.class, InjectBeanSelfProcessor.class})
@EnableCaching(proxyTargetClass = true)
public class CacheConfig implements LoadTimeWeavingConfigurer {
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
  public enum CacheConstant {
    productCache(1, TimeUnit.HOURS, 100),
    ;
    private long expireTime = DEFAULT_EXPIRE_TIME;
    private TimeUnit timeUnit = DEFAULT_TIME_UNIT;
    private long maxSize = DEFAULT_MAXSIZE;

    /**
     * use default params
     */
    CacheConstant(){}

    CacheConstant(long expireTime){
      this.expireTime = expireTime;
    }

    CacheConstant(long expireTime, TimeUnit timeUnit){
      this.expireTime = expireTime;
      this.timeUnit = timeUnit;
    }

    CacheConstant(long expireTime, TimeUnit timeUnit, long maxSize){
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

  @Bean
  @Primary
  public CacheManager guavaCacheManager() {
    SimpleCacheManager cacheManager = new SimpleCacheManager();

    List<Cache> caches = new ArrayList<Cache>();
    for(CacheConstant c : CacheConstant.values()){
      caches.add(new ConcurrentMapCache(c.name()));
    }
    cacheManager.setCaches(caches);
    return cacheManager;
  }

}
