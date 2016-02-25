package com.figer.spring.aop;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

public class SpringAopAdviceTest {
	public static void main(String[] args) {
		Waiter waiter = new NaiveWaiter();
		BeforeAdvice advice = new PolitenessBeforeAdvice();
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.addAdvice(advice);
		proxyFactory.setTarget(waiter);
		
		Waiter waiterProxy = (Waiter) proxyFactory.getProxy();
		waiterProxy.greetTo("John");
		waiterProxy.serveTo("Tom");
	}
}
