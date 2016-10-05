package com.figer.pattern.builder;

/**
 * Created by figer on 10/5/16.
 */
public class Director {
  private Builder builder;

  public Director(Builder builder){
    this.builder = builder;
  }

  public Product construct(){
    builder.buildPartA();
    builder.buildPartB();
    builder.buildPartC();
    return builder.getResult();
  }
}
