package com.figer.spring.configuration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by figer on 26/04/2017.
 */
public class Client {
  public static void main(String[] args) {
    System.out.println(System.getProperty("java.class.path"));

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
    MyComponent component = applicationContext.getBean("myComponent", MyComponent.class);
    System.out.println(component.getName());
    System.out.println(component.getAge());
    System.out.println(component.getIntList().toString());
  }
}
