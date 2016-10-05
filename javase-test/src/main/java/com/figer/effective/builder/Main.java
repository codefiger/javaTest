package com.figer.effective.builder;

/**
 * Created by figer on 9/26/16.
 */
public class Main {
  public static void main(String[] args) {
    Phone phone =new Phone.Builder(12345L)
        .setColor("red")
        .setWidth(100)
        .setLength(500)
        .setHeight(10)
        .build();
  }
}
