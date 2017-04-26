package com.figer.basic;

/**
 * Created by figer on 24/04/2017.
 */
public class FinallyDemo {
  public static void main(String[] args) {
    System.out.println("jvm 名称：\t" + System.getProperty("java.vm.name"));
    System.out.println("jvm 实现版本：\t" + System.getProperty("java.vm.version"));
    System.out.println("jvm 规范版本：\t" + System.getProperty("java.vm.specification.version"));

    System.out.println("-------with exception-----");
    System.out.println("return : " + new FinallyDemo().demo1(EXCEPTION_FACTOR));
    System.out.println("-------without exception-----");
    System.out.println("return : " + new FinallyDemo().demo1(NON_EXCEPTION_FACTOR));

    System.out.println("------without return statement in finally block----");
    System.out.println("return : " + new FinallyDemo().demo2());
  }

  private static final String EXCEPTION_FACTOR = "exception";
  private static final String NON_EXCEPTION_FACTOR = "non-exception";

  private String demo1(String factor){
    try {
      System.out.println("do something in try block");
      if(EXCEPTION_FACTOR.equalsIgnoreCase(factor)){
        throw new RuntimeException();
      }
      return "try value";
    } catch (Exception e) {
      System.out.println("occurred an exception in catch block");
      return "catch value";
    } finally {
      System.out.println("do something in finally block");
      return "finally value";
    }
  }

  private String demo2(){
    try {
      System.out.println("do something in try block");
      return "try value";
    } finally {
      System.out.println("do something in finally block");
    }
  }
}
