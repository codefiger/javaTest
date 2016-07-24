package com.figer;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static org.mockito.Mockito.*;
import static java.lang.System.out;
import static java.lang.Integer.*;
/**
 * Created by figer on 7/24/16.
 */
public class HelloWorld {

  @Test
  public void testVerify(){
    System.out.println("testPortfolioService start");

    //mock creation
    List mockedList = mock(List.class);

    //using mock object - it does not throw "unexpected interaction" exception
    mockedList.add("one");
    //mockedList.clear();

    //selective, explicit, highly readable verification
    verify(mockedList, atLeastOnce()).add("one");
    verify(mockedList).clear();
  }

  @Test
  public void testStubMethod(){
    //you can mock concrete classes, not only interfaces
    LinkedList mockedLinkedList = mock(LinkedList.class);

    //stubbing appears before the actual execution
    when(mockedLinkedList.get(0)).thenReturn("first");

    //the following prints "first"
    System.out.println(mockedLinkedList.get(0));

    //the following prints null because get(999) was not stubbed
    System.out.println(mockedLinkedList.get(999));
  }

  @Test
  public void testStaticImport(){
    out.println("static import System.out:hello world");
    out.println(toHexString(new Random().nextInt(10)));
  }
}
