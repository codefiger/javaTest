package com.figer.pattern.flyweight;

/**
 * Created by figer on 05/11/2016.
 */
public class Rectangle implements IShape {
  @Override
  public void draw() {
    System.out.println("Here is a rectangle.");
  }
}
