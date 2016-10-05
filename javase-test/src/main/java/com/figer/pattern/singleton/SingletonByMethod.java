package com.figer.pattern.singleton;

/**
 * Created by figer on 10/5/16.
 */
public class SingletonByMethod {
  private static SingletonByMethod instance = null;

  private SingletonByMethod() {
  }

  private static synchronized SingletonByMethod getInstanceSync(){
    if(instance == null){
      instance = new SingletonByMethod();
    }
    return instance;
  }

  public static SingletonByMethod getInstance(){
    return getInstanceSync();
  }
}
