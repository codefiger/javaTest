package com.figer.pattern.nullobject;

import java.math.BigDecimal;

/**
 * Created by figer on 18/11/2016.
 */
public class NullObjectClient {
  public static void main(String[] args) {
    OrderServiceFactory serviceFactory = new OrderServiceFactory();

    IOrderService orderService = serviceFactory.getService(OrderServiceFactory.OrderType.purchase);
    Long orderId;
    orderId = orderService.create(BigDecimal.ONE);
    System.out.println(orderId);
    System.out.println(orderService.execute(orderId));

    System.out.println("==============");
    orderService = serviceFactory.getService(null);
    orderId = orderService.create(BigDecimal.ONE);
    System.out.println(orderId);
    System.out.println(orderService.execute(orderId));
  }
}
