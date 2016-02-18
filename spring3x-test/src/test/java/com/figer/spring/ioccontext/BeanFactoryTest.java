package com.figer.spring.ioccontext;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.figer.domain.User;

public class BeanFactoryTest {
	public static void main(String[] args) { 
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
		User user3 = (User)applicationContext.getBean("user");
		System.out.println(user3.getUserName());
	}
}
