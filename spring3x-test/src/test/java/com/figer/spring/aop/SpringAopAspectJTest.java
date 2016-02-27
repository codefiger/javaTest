package com.figer.spring.aop;

import java.io.Serializable;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.figer.domain.Sellable;
import com.figer.domain.User;
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
	@Autowired
	private Serializable user;
	@Autowired(required=false)
	private Sellable smartSeller;
	@Autowired(required=false)
	private Sellable maleSeller;
	
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
	
	@Test
	public void testAspectJAopByConfired(){
		waiter.greetTo("figer");
		waiter.serveTo("figer");
	}
	
	@Test
	public void testAspectJIntroductionAdiver(){
		waiter.greetTo("figer");
		Sellable seller = (Sellable) waiter;
		seller.sell("pencil");
	}
	
	@Test
	public void testAspectFunction(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/aop/aspectj/aopbeans.xml");
		Sellable seller1 = (Sellable) ctx.getBean("smartSeller");
		Sellable maleSeller1 = (Sellable) ctx.getBean("maleSeller");
		seller1.sell("rice");
		maleSeller1.sell("male rice");
		
		smartSeller.sell("sdsd");
	}
	
	@Test
	public void testAspectExecution(){
	}
	
	@Test
	public void testAspectAround(){
		waiter.greetTo("figer");
		waiter.serveTo("figer");
		
		seller.greetTo("figer");
		
		user.toString();
	}
}
