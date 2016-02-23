package com.figer.beanfactory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.figer.domain.Car;
import com.figer.injectfun.MagicBoss;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath*:beans.xml"
})
public class BeanFactoryTest {
	@Autowired
	private Car carByFactory;
	
	@Autowired
	private Car car2;
	
	@Autowired
	private MagicBoss magicBoss;
	
	@Autowired
	private Car car3;
	
	@Autowired
	private Car car4;
	@Test
	public void testCarFactory(){
		System.out.println(carByFactory);
		System.out.println(car2);
	}
	
	@Test
	public void testLookupFunctionInject(){
		//每次拿到的car都不一样
		System.out.println(magicBoss.getCar() == magicBoss.getCar());
	}
	
	@Test
	public void testBeanOOP(){
		//每次拿到的car都不一样
		System.out.println(car3);
		System.out.println(car4);
	}
}
