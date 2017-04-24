package com.figer.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * Created by figer on 17/04/2017.
 */
@Service
public class OrderService {
  @Autowired
  private ApplicationEventPublisher eventPublisher;

  public void create(){
    System.out.println("OrderService: do something");

    eventPublisher.publishEvent(new MsgSendEvent("create order success"));

    System.out.println("end");
  }
}
