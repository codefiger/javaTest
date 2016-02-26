package com.figer.spring.aop.aspectj;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AnnotationAspect {
	@AfterReturning("@annotation(com.figer.annotation.Description)")
	public void descriptionFun(){
		System.out.println("this function has description");
	}
}
