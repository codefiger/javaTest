package com.figer.cacheblog;

import com.google.common.collect.Lists;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by figer on 14/12/2016.
 */
@Configuration
@EnableCaching
public class MyCacheConfig {
  @Bean(name = "cacheManager")
  public GuavaCacheManager guavaCacheManager(){
    GuavaCacheManager cacheManager = new GuavaCacheManager();
    cacheManager.setCacheNames(Lists.newArrayList("orderCache"));
    return cacheManager;
  }

  @Bean
  public IOrderService orderService(){
    return new OrderServiceImpl();
  }

}
