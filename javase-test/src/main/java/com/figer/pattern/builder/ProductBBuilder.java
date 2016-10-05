package com.figer.pattern.builder;

/**
 * Created by figer on 10/5/16.
 */
public class ProductBBuilder extends Builder{
  @Override
  public void buildPartA() {
    product.setPartA("ProductBBuilder.buildPartA");
  }

  @Override
  public void buildPartB() {
    product.setPartB("ProductBBuilder.buildPartB");
  }

  @Override
  public void buildPartC() {
    product.setPartC("ProductBBuilder.buildPartC");
  }
}
