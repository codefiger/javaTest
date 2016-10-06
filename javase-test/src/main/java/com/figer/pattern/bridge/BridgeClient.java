package com.figer.pattern.bridge;

/**
 * Created by figer on 10/6/16.
 */
public class BridgeClient {
  public static void main(String[] args) {
    Implementor impl = new ConcreteImplementorA();
    Abstraction completeThing = new RefinedAbstractionA();
    completeThing.setImpl(impl);
    completeThing.operation();
  }
}
