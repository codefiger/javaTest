package com.figer.spring.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.figer.spring.aop.aspectj.PreGreetingAspect;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath:spring/aop/aspectj/aopbeans.xml"
})
public class SpringAopAspectJTest {
	@Autowired
	private Waiter waiter;
	@Autowired
	private Seller seller;
	@Test
	public void testAspectJAop(){
		AspectJProxyFactory aspectJProxyFactory = new AspectJProxyFactory();
		aspectJProxyFactory.setTarget(waiter);
		aspectJProxyFactory.addAspect(PreGreetingAspect.class);
		Waiter proxyWaiter = aspectJProxyFactory.getProxy();
		waiter.greetTo("figer");
		waiter.serveTo("figer");
		System.out.println("-------");
		proxyWaiter.greetTo("figer");
		proxyWaiter.serveTo("figer");
	}
}
