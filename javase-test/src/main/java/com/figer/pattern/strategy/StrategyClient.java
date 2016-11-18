package com.figer.pattern.strategy;

/**
 * Created by figer on 18/11/2016.
 */
public class StrategyClient {
  public static void main(String[] args) {
    OrderService orderService = new OrderService(new LocalStrategy());
    orderService.dothing();
  }
}
