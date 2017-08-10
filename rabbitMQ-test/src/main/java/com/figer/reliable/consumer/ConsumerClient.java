package com.figer.reliable.consumer;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by figer on 24/07/2017.
 */
public class ConsumerClient {
  public static void main(String[] args) throws Exception{
    new AnnotationConfigApplicationContext(RabbitMQConsumerConfig.class);
  }
}
