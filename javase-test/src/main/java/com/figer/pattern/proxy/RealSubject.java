package com.figer.pattern.proxy;

/**
 * Created by figer on 10/6/16.
 */
public class RealSubject implements Subject {
  @Override
  public void request() {
    System.out.println("invoke the real request...");
  }
}
