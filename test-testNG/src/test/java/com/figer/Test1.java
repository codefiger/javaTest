package com.figer;


import com.figer.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

/**
 * Created by figer on 06/11/2016.
 */
@Test
@ContextConfiguration(classes = {com.figer.service.MyService.class})
public class Test1 extends AbstractTestNGSpringContextTests {
  @BeforeClass
  public void setUp(){
    System.out.println("setUp...");
  }

  @Autowired
  MyService myService;
  @Test
  public void testIntegrationWithSpring(){
    assertNotNull(myService);
  }

  @Test
  public void testJustTest(){
    System.out.println(10 << 2);
    System.out.println("HelloWorld");
    String str = "TestNG is working fine";
    assertEquals("TestNG is working fine", str);
    sleepAWhile();
  }

  @DataProvider
  public Object[][] providerMethod(Method method){
    Object[][] result = null;
    if(method.getName().equals("testDataProviderMethod")){
      result = new Object[][]{new Object[]{1}};
    }else if(method.getName().equals("testmethod2")){
      result = new Object[][]{new Object[]{2}};
    }else{
      result = new Object[][]{new Object[]{3}};
    }
    return result;
  }

  @Test(dataProvider="providerMethod")
  public void testDataProviderMethod(int param){
    System.out.println("method1 received:"+param);

    sleepAWhile();
  }

  @Test(dataProvider="providerMethod")
  public void testDataProviderMethod2(int param){
    System.out.println("method2 received:"+param);
    sleepAWhile();
  }

  @DataProvider
  public Object[][] multiProvider(){
    int size = 10;
    Object[][] result = new Object[size][];
    for(int i=0;i<size;i++){
      result[i] = new Object[]{i, "index" + i};
    }
    return result;
  }

  @Test(dataProvider="multiProvider")
  public void testMultiProvider(int index, String name){
    System.out.println("method1 received:" + name + " ----index:" + index);
  }


  @AfterClass
  public void afterClass() {
    System.out.println("afterClass");
    sleepAWhile();
  }

  private void sleepAWhile(){
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
