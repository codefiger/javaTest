package com.figer.spring.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class PolitenessAfterAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("Please enjoy yourself!");
	}

}
