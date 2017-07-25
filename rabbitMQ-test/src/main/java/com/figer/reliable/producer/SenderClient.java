package com.figer.reliable.producer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

/**
 * Created by figer on 24/07/2017.
 */
public class SenderClient {
  public static void main(String[] args) {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(RabbitMQProducerConfig.class);
    RabbitMQEventSender eventSender = applicationContext.getBean("rabbitMQEventSender", RabbitMQEventSender.class);
    int index = 111;
    Scanner scanner = new Scanner(System.in);
    while(scanner.nextBoolean()){
      eventSender.send(new Msg("id" + index++, "name", 5.5));
    }
  }

}
