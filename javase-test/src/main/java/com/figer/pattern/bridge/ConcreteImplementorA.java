package com.figer.pattern.bridge;

/**
 * Created by figer on 10/6/16.
 */
public class ConcreteImplementorA implements Implementor {
  @Override
  public void operationImpl() {
    System.out.println("ConcreteImplementorA: operationImpl...");
  }
}
