package com.figer;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by figer on 06/11/2016.
 */
public class Test1 {
  @BeforeClass
  public void setUp(){
    System.out.println("setUp...");
  }

  @Test
  public void testJustTest(){
    System.out.println("HelloWorld");
  }

  @AfterClass
  public void afterClass(){
    System.out.println("afterClass");
  }
}
