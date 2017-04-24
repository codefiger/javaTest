package com.figer.pattern.proxy.test;

/**
 * Created by figer on 14/04/2017.
 */
public class ClientA {
  public void doSomething(){
    OrderService orderService = new OrderService();
    MessageService messageService = new MessageService();
    orderService.create();
    messageService.sendMessage();
  }
}
