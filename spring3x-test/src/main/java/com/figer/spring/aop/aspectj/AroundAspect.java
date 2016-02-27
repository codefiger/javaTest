package com.figer.spring.aop.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AroundAspect {
	@Around("execution(* greetTo(..)) and target(com.figer.spring.aop.NaiveWaiter)")
	public void aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("method before...");
		joinPoint.proceed();
		System.out.println("method ater...");
	}
}
