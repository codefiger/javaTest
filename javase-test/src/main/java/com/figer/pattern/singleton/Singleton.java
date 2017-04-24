package com.figer.pattern.singleton;

/**
 * Created by figer on 12/04/2017.
 */
public class Singleton {
  //饿汉式，被ClassLoader加载后第一时间就被创建了
  private static Singleton instance = new Singleton();

  private Singleton(){}

  public Singleton getInstance(){
    return instance;
  }
}
