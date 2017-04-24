package com.figer;

import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
//import static org.testng.Assert.assertEquals;

/**
 * Created by figer on 06/11/2016.
 */
public class TestDemo {
  @Test
  public void testAdd() {
   /* String str = "TestNG is working fine";
    //assertEquals("TestNG is working fine", str);
    Runtime runtime = Runtime.getRuntime();
    System.out.println(runtime);*/

    /*TimeUnit minutes = TimeUnit.MINUTES;
    System.out.println(minutes.toSeconds(2));*/
    String nodesArray[] = "1212:8080".split(",");
    System.out.println(Arrays.toString(nodesArray));

  }


  private void printSql(){

  }
}
