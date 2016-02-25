package com.figer.spring.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.figer.pattern.proxy.jdk.Car;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath*:mailbeans.xml"
})
public class SpringAdviceTest {
	@Autowired
	private Waiter waiterProxy;
	@Autowired
	private Waiter waiterAround;
	@Autowired
	private Car transactionCar;
	@Autowired
	private Waiter waiterAdvitor;
	@Autowired
	private Seller sellerAdvitor;
	@Autowired
	private Waiter waiterRegexAdvisor;
	@Autowired
	private Seller seller;
	@Autowired
	private Waiter naiveWaiter;
	
	@Test
	public void testBeforeAdvice(){
		waiterProxy.greetTo("figer");
	}
	
	@Test
	public void testAopAroud(){
		waiterAround.greetTo("figer");
	}
	
	@Test
	public void testAopThrowingAdvince(){
		transactionCar.doSomething();
	}
	
	@Test
	public void testStaticMethodAdvisor(){
		waiterAdvitor.greetTo("John");
		sellerAdvitor.greetTo("Tom");
	}
	
	@Test
	public void testRegexAdvisor(){
		waiterRegexAdvisor.greetTo("John");
		waiterRegexAdvisor.serveTo("Tom");
	}
	
	@Test
	public void testBeanNameAutoProxyCreator(){
		seller.greetTo("John");
		naiveWaiter.greetTo("Tom");
	}
	
}
