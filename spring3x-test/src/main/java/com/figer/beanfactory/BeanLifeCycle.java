package com.figer.beanfactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
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
	}
	
	public static void main(String[] args) {
		lifeCycleInBeanFactory();
	}
}
