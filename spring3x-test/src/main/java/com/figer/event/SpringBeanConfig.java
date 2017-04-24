package com.figer.event;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Created by figer on 17/04/2017.
 */
@EnableAsync
@Configuration
public class SpringBeanConfig {

  public @Bean OrderService orderService(){
    return new OrderService();
  }

  public @Bean MsgHandler msgHandler(){
    return new MsgHandler();
  }
}
