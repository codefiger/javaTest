package com.figer.springevent;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Created by figer on 28/07/2017.
 */
@Configuration
@EnableAsync
@ComponentScan(basePackages = "com.figer.springevent")
public class AppConfig {

  @EventListener
  @Async
  public void consumeEvent(MyEvent event){
    System.out.println("consumer:" + Thread.currentThread() + " -source:" + event.getSource());
  }

  @Bean
  public Producer producer(){
    return new Producer();
  }
}
