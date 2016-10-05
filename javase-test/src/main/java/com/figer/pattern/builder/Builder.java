package com.figer.pattern.builder;

/**
 * Created by figer on 10/5/16.
 */
public abstract class Builder {
  protected Product product = new Product();

  public abstract void buildPartA();
  public abstract void buildPartB();
  public abstract void buildPartC();

  public Product getResult(){
    return product;
  }
}
