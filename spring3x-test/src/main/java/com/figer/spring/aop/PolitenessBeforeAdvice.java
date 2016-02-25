package com.figer.spring.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class PolitenessBeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		String customerName = (String)args[0];
		System.out.println("How are you? Mr." +customerName);
	}

}
