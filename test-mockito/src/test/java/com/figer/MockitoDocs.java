package com.figer;

import com.figer.service.PortfolioService;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

//Let's import Mockito statically so that the code looks clearer
import static org.mockito.Mockito.*;
import static java.lang.System.out;
import static java.lang.Integer.*;
/**
 * Created by figer on 7/24/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:application-test.xml"})
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
      public void describeMismatch(Object item, Description mismatchDescription) {

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
  public void testAvoidInteractions(){
    List mockOne = mock(List.class);
    List mockTwo = mock(List.class);

    mockOne.add("one");
    mockOne.add("dd");
    //ordinary verification
    verify(mockOne).add("one");
    verify(mockOne).add("dd");

    //verify that method was never called on a mock
    verify(mockOne, never()).add("two");

    //mockTwo.add(mockOne);
    //verify that method were not interacted, example:mockOne.add(mockTwo); or mockTwo.add(mockOne);
    verifyZeroInteractions(mockOne, mockTwo);

    //mockOne.add(mockTwo);

    //Checks if any of given mocks has any unverified interaction. --  Finding redundant invocations
    verifyNoMoreInteractions(mockOne);

  }

  @Autowired private PortfolioService portfolioService;
  @Test
  public void testShorthandMokCreation(){
    PortfolioService spy = spy(portfolioService);

    when(spy.purchase(anyLong(), eq("mock-test"), any(BigDecimal.class))).thenReturn(true);
    when(spy.purchase(anyLong(), eq("others"), any(BigDecimal.class))).thenReturn(false);

    Assert.assertTrue(spy.purchase(12345L, "mock-test", BigDecimal.ONE));
    Assert.assertFalse(spy.purchase(12345L, "others", BigDecimal.ONE));
  }

  @Test
  public void testConsecutiveCalls(){
    List mock = mock(List.class);
    when(mock.get(anyInt()))
        .thenThrow(new RuntimeException("first time throw runtime exception"))
        .thenReturn("second", "three times", "four times");

    for (int i = 0; i < 4; i++) {
      if(i == 0){
        try {
          mock.get(1);
        }catch (Exception e){
          Assert.assertEquals("first time throw runtime exception", e.getMessage());
        }
      }else{
        System.out.println( mock.get(1));
      }

    }

  }

  @Test
  public void testStubbingWithCallback(){
    List mock = mock(List.class);

    when(mock.get(anyInt())).thenAnswer(new Answer<Boolean>() {
      @Override
      public Boolean answer(InvocationOnMock invocation) throws Throwable {
        return true;
      }
    });

    for (int i = 0; i < 10; i++) {
      Assert.assertTrue((Boolean) mock.get(i));
    }
  }

  @Test
  public void testStubbingDefaultReturn(){
    //I don't understand 这有什么蛋用...
    PortfolioService mock = mock(PortfolioService.class, Mockito.RETURNS_SMART_NULLS);
    Assert.assertFalse(mock.purchase(12345L, "others", BigDecimal.ONE));
  }

  @Test
   public void test(){

  }
}
