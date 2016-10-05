package com.figer.pattern.builder;

/**
 * Created by figer on 10/5/16.
 */
public class ProductABuilder extends Builder{
  @Override
  public void buildPartA() {
    product.setPartA("ProductABuilder.buildPartA");
  }

  @Override
  public void buildPartB() {
    product.setPartB("ProductABuilder.buildPartB");
  }

  @Override
  public void buildPartC() {
    product.setPartC("ProductABuilder.buildPartC");
  }
}
