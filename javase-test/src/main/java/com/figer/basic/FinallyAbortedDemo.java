package com.figer.basic;

/**
 * Created by figer on 24/04/2017.
 */
public class FinallyAbortedDemo {
  public static void main(String[] args) throws InterruptedException {
    //call System.exit()
   /* try {
      System.out.println("do something in try block");
      System.exit(-1);
    }finally {
      System.out.println("do something in finally block");
    }*/

    //call infinite loop
    /*try {
      System.out.println("do something in try block");
      while (true){
        //do something
      }
    }finally {
      System.out.println("do something in finally block");
    }*/

    try {
      System.out.println("do something in try block");
      //Thread.sleep(1000000);
      Thread.currentThread().stop();
    }finally {
      System.out.println("do something in finally block");
    }
  }
}
