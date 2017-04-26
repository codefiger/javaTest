package com.figer.reflect.bean;

/**
 * Created by figer on 25/04/2017.
 */
public class MyService implements IMyService{
  public int index;
  private String name;

  public void doSomething(){
    System.out.println("do something in MyService");
  }
}
