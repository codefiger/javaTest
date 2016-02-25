package com.figer.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class PolitenessInterceptor implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object[] args = invocation.getArguments();
		String customerName = (String)args[0];
		System.out.println("How are you? Mr." +customerName);
		Object result = invocation.proceed();
		System.out.println("Please enjoy yourself!");
		return result;
	}

}
