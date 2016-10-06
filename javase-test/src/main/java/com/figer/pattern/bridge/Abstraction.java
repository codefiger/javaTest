package com.figer.pattern.bridge;

/**
 * Created by figer on 10/6/16.
 */
public abstract class Abstraction {
  protected Implementor impl;

  public Abstraction() {
  }

  public void setImpl(Implementor impl) {
    this.impl = impl;
  }

  public abstract void operation();
}
