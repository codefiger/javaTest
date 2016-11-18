package com.figer.pattern.strategy;

/**
 * Created by figer on 18/11/2016.
 */
public class LocalStrategy implements IStrategy {
  @Override
  public void execute() {
    System.out.println("LocalStrategy");
  }
}
