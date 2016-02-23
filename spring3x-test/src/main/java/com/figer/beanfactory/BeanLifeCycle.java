package com.figer.beanfactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.figer.domain.Car;

public class BeanLifeCycle {
	private static void lifeCycleInBeanFactory(){
		ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
		Resource resource = resourceResolver.getResource("classpath:beans.xml");
		BeanFactory beanFactory = new XmlBeanFactory(resource);
		((ConfigurableBeanFactory)beanFactory).addBeanPostProcessor(new MyBeanPostProcessor());
		((ConfigurableBeanFactory)beanFactory).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());
		
		Car car = (Car)beanFactory.getBean("car");
		System.out.println(car.toString());
		
		Car car2 = beanFactory.getBean("car",Car.class);
		System.out.println(car == car2);
		((XmlBeanFactory)beanFactory).destroySingletons();
		
		//application 和 beanFactory 最大的区别就是前者会利用Java反射自动识别出配置定义的BeanPostProcessor,InstantiationAwareBeanPostProcessor
		//但是bean类就耦合了spring的BeanPostProcessor,InstantiationAwareBeanPostProcessor接口，如何解耦？
		//init-method,destroy-method 可以实现解耦并对bean进行控制
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:beans.xml");
		Car car3 = applicationContext.getBean("car", Car.class);
		System.out.println(car3);
	}
	
	public static void main(String[] args) {
		lifeCycleInBeanFactory();
	}
}
