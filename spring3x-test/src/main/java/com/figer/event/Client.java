package com.figer.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by figer on 17/04/2017.
 */
public class Client {
  public static void main(String[] args) {
    AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext(SpringBeanConfig.class);
    OrderService orderService = annotationContext.getBean(OrderService.class);

    orderService.create();
  }
}
