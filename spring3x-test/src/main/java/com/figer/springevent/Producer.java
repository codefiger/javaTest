package com.figer.springevent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

/**
 * Created by figer on 28/07/2017.
 */
public class Producer {

  @Autowired
  private ApplicationEventPublisher eventPublisher;

  public void doSomething(){
    System.out.println("11111" + Thread.currentThread());
    eventPublisher.publishEvent(new MyEvent(111));
  }
}
