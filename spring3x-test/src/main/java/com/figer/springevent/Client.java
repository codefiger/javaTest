package com.figer.springevent;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by figer on 28/07/2017.
 */
public class Client {
  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    context.getBean(Producer.class).doSomething();
  }
}
