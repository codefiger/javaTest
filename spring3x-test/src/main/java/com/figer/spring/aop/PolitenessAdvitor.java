package com.figer.spring.aop;

import java.lang.reflect.Method;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

public class PolitenessAdvitor extends StaticMethodMatcherPointcutAdvisor {
	private static final long serialVersionUID = 7330814669473498706L;

	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		return "greetTo".equals(method.getName());
	}
	
	@Override
	public ClassFilter getClassFilter() {
		return new ClassFilter() {
			
			@Override
			public boolean matches(Class<?> clazz) {
				return Waiter.class.isAssignableFrom(clazz);
			}
		};
	}

}
