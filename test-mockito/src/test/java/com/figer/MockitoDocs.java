package com.figer;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Test;
import org.mockito.InOrder;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

//Let's import Mockito statically so that the code looks clearer
import static java.lang.System.in;
import static org.mockito.Mockito.*;
import static java.lang.System.out;
import static java.lang.Integer.*;
/**
 * Created by figer on 7/24/16.
 */
public class MockitoDocs {

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

    verify(mockedLinkedList).get(0);
  }

  @Test
  public void testArgumentMatcher(){
    List mockedList = mock(List.class);
    //stubbing using build-in anyInt() argument matcher
    when(mockedList.get(anyInt())).thenReturn("anyIntMatcher");

    //stubbing using custom matcher(return my own implementation)
    when(mockedList.contains(argThat(isValid()))).thenReturn(true);

    System.out.println(mockedList.contains(1));

    System.out.println(mockedList.get(2));
  }

  private Matcher isValid(){
    return new Matcher() {
      @Override
      public boolean matches(Object o) {
        return false;
      }

      @Override
      public void _dont_implement_Matcher___instead_extend_BaseMatcher_() {

      }

      @Override
      public void describeTo(Description description) {

      }
    };
  }

  @Test
  public void testVerifyExactNum(){
    List mockedList = mock(List.class);
    mockedList.add("once");

    mockedList.add("twice");
    mockedList.add("twice");

    mockedList.add("three times");
    mockedList.add("three times");
    mockedList.add("three times");

    //following two verifications work exactly the same - times(1) is used by default
    verify(mockedList).add("once");
    verify(mockedList, times(1)).add("once");

    //exact number of invocations verification
    verify(mockedList, times(2)).add("twice");
    verify(mockedList, times(3)).add("three times");

    //verification using never(): is an alias to times(0)
    verify(mockedList, never()).add("never happened");

    //verification using atLeast()/atMost()
    verify(mockedList, atLeast(2)).add("twice");
    verify(mockedList, atLeast(2)).add("three times");
    verify(mockedList, atMost(1)).add("once");
  }

  @Test
  public void testStaticImport(){
    out.println("static import System.out:hello world");
    out.println(toHexString(new Random().nextInt(10)));
  }

  @Test
  public void testStubVoidMethod(){
    List mockedList = mock(List.class);
    doThrow(new RuntimeException("Stubbing void method with exceptions")).when(mockedList).clear();

    mockedList.add("once");
    mockedList.clear();
  }

  @Test
  public void testVerificationInOrder(){
    // A. Single mock whose methods must be invoked in a particular order
    List singleMock = mock(List.class);

    //using a single mock
    singleMock.add("was added first");
    singleMock.add("was added second");

    //create an inOrder verifier for a single mock
    InOrder inOrder = inOrder(singleMock);

    //following will make sure that add is first called with "was added first, then with "was added second"
    inOrder.verify(singleMock).add("was added first");
    inOrder.verify(singleMock).add("was added second");

    // B. Multiple mocks that must be used in a particular order
    List firstMock = mock(List.class);
    List secondMock = mock(List.class);

    //using mocks
    firstMock.add("was called first");
    secondMock.add("was called second");
    secondMock.add("secondMock was called second");
    firstMock.add("firstMock was called second");

    //create inOrder object passing any mocks that need to be verified in order
    InOrder multiInOrder = inOrder(firstMock, secondMock);

    //following will make sure that firstMock was called before secondMock
    multiInOrder.verify(firstMock).add("was called first");
    multiInOrder.verify(secondMock).add("was called second");
    multiInOrder.verify(secondMock).add("secondMock was called second");
    multiInOrder.verify(firstMock).add("firstMock was called second");

    // Oh, and A + B can be mixed together at will
  }

  @Test
   public void test(){

  }
}
