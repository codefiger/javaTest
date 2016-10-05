package com.figer.pattern.builder;

/**
 * Created by figer on 10/5/16.
 */
public class Product {
  private String partA;
  private String partB;
  private String partC;

  public String getPartA() {
    return partA;
  }

  public void setPartA(String partA) {
    this.partA = partA;
  }

  public String getPartB() {
    return partB;
  }

  public void setPartB(String partB) {
    this.partB = partB;
  }

  public String getPartC() {
    return partC;
  }

  public void setPartC(String partC) {
    this.partC = partC;
  }

  @Override
  public String toString() {
    return "partA:" + partA + ";   " +
        "partB:" + partB + ";   " +
        "partC:" + partC;
  }
}
