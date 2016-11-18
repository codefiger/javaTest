package com.figer.pattern.strategy;

/**
 * Created by figer on 18/11/2016.
 */
public class OrderService {
  private IStrategy strategy;

  public OrderService(IStrategy strategy) {
    this.strategy = strategy;
  }

  public void dothing(){
    strategy.execute();
  }
}
