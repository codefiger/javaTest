package com.figer.pattern.nullobject;

import java.math.BigDecimal;

/**
 * Created by figer on 18/11/2016.
 */
public class NullObjectClient {
  public static void main(String[] args) {
    SenderFactory serviceFactory = new SenderFactory();

    Sender orderService = serviceFactory.getSender(SenderFactory.OrderType.purchase);
    Long orderId;
    orderId = orderService.create(BigDecimal.ONE);
    System.out.println(orderId);
    System.out.println(orderService.execute(orderId));

    System.out.println("==============");
    orderService = serviceFactory.getSender(null);
    orderId = orderService.create(BigDecimal.ONE);
    System.out.println(orderId);
    System.out.println(orderService.execute(orderId));
  }
}
