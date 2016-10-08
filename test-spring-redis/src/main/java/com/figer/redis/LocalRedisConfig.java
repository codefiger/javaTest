package com.figer.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by figer on 08/10/2016.
 */
@Configuration
@ComponentScan(basePackages="com.figer.redis.dao")
public class LocalRedisConfig {

  @Bean
  public RedisConnectionFactory jedisConnectionFactory(){
    JedisPoolConfig poolConfig = new JedisPoolConfig();
    /*poolConfig.maxActive = 10;
    poolConfig.maxIdle = 5;
    poolConfig.minIdle = 1;
    poolConfig.testOnBorrow = true;
    poolConfig.testOnReturn = true;
    poolConfig.testWhileIdle = true;*/
    JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(poolConfig);
    return jedisConnectionFactory;
  }

  @Bean
  public StringRedisTemplate redisTemplate(){
    StringRedisTemplate redisTemplate = new StringRedisTemplate(jedisConnectionFactory());
    return redisTemplate;
  }
}