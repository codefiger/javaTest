package com.figer.pattern.command;

/**
 * Created by figer on 07/10/2016.
 */
public class CommandClient {
  public static void main(String[] args) {
    Invoker invoker = new Invoker(new ConcreteCommand());
    invoker.request();
  }
}
