package com.figer.spring.aop.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class PreGreetingAspect {
	@Before("execution(* greetTo(..))")
	public void beforeGreeting(){
		System.out.println("How are you?");
	}
}
