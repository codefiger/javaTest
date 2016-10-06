package com.figer.pattern.bridge;

/**
 * Created by figer on 10/6/16.
 */
public class RefinedAbstractionB extends Abstraction{
  @Override
  public void operation() {
    impl.operationImpl();
    System.out.println("RefinedAbstractionB deal it...");
  }
}
