package com.figer.spring.ioccontext;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.figer.beanfactory.MyBeanPostProcessor;
import com.figer.beanfactory.MyInstantiationAwareBeanPostProcessor;
import com.figer.domain.Car;
import com.figer.domain.User;

public class BeanFactoryTest {
	public static void main(String[] args) { 
		//beanFactory();
		lifeCycleInBeanFactory();
	}
	
	private static void beanFactory(){
		ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
		Resource resource = resourceResolver.getResource("classpath:beans.xml");
		BeanFactory xmlBeanFactory = new XmlBeanFactory(resource);
		User user = (User) xmlBeanFactory.getBean("user");
		System.out.println(user.getUserId());
		
		//XmlBeanFactory deprecated spring doc 推荐 DefaultListableBeanFactory and XmlBeanDefinitionReader
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
		reader.loadBeanDefinitions(resource);
		User user2 = (User)beanFactory.getBean("user");
		System.out.println(user2.getPassword());
		
		//这种更常见,ApplicationContext is a sub-interface of BeanFactory
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:beans.xml");
		User user3 = applicationContext.getBean("user", User.class);
		System.out.println(user3.getUserName());
		
		//ApplicationContext  资源前缀可以不加，默认就是文件系统
		ApplicationContext ctx = new FileSystemXmlApplicationContext("file:/Users/figer/Documents/workspace/test/beans.xml");
		User user4 = ctx.getBean("user", User.class);
		System.out.println(user4.getUserName());
		
		//ApplicationContext annotation config
		ApplicationContext annotationCtx = new AnnotationConfigApplicationContext(AnnotationBeansTest.class);
		User user5 = annotationCtx.getBean("user", User.class);
		System.out.println(user5.getUserName());
	}
	
	private static void lifeCycleInBeanFactory(){
		ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
		Resource resource = resourceResolver.getResource("classpath:beans.xml");
		BeanFactory beanFactory = new XmlBeanFactory(resource);
		((ConfigurableBeanFactory)beanFactory).addBeanPostProcessor(new MyBeanPostProcessor());
		((ConfigurableBeanFactory)beanFactory).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());
		
		User user = (User) beanFactory.getBean("user");
		System.out.println(user.getUserId());
		
		Car car = (Car)beanFactory.getBean("car");
		System.out.println(car.toString());
		
		Car car2 = beanFactory.getBean("car",Car.class);
		System.out.println(car == car2);
		((XmlBeanFactory)beanFactory).destroySingletons();
	}
	
}
