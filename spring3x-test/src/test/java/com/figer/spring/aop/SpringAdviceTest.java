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
}
