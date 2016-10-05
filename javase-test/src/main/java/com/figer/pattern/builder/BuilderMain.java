package com.figer.pattern.builder;

/**
 * Created by figer on 10/5/16.
 */
public class BuilderMain {
  public static void main(String[] args) {
    Builder builder = new ProductBBuilder();
    Director director = new Director(builder);
    Product product = director.construct();
    System.out.println(product);
  }
}
