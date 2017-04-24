package com.figer.pattern.abstractFactory.springbeanfactory;

import com.figer.pattern.abstractFactory.Sender;

/**
 * Created by figer on 18/04/2017.
 */
public class Client {
  public static void main(String[] args) {
    BeanFactory beanFactory = new AnnotationBeanFactory();
    Sender sender = (Sender) beanFactory.getBean("sender");
    sender.send();
  }
}
