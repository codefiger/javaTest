package com.figer.exception;

/**
 * Created by figer on 9/19/16.
 */
public class App {
  public static void main(String[] args) throws Exception {
    try {
      print();
    } catch (Exception e) {
      System.out.println("111");
      throw e;
    }
  }

  private static void print() throws Exception{
    System.out.println("print something...");
    throw new Exception("occur a exception");
  }
}
