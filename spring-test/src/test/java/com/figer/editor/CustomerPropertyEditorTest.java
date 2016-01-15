package com.figer.editor;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.figer.entity.User;

public class CustomerPropertyEditorTest {
	private static BeanFactory beanFactory;

	public static void main(String[] args) {
		beanFactory = new ClassPathXmlApplicationContext("applicationContext.xml");
		User user = (User) beanFactory.getBean("figer");
		System.out.println(user.getCompany());
	}
}
