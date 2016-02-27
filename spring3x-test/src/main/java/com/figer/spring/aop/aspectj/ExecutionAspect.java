package com.figer.spring.aop.aspectj;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
/**
 * execution(<修饰符模式> ？ <返回类型模式> <方法名模式> (<参数模式>) <异常模式> ?)
 * 其中 返回类型模式 方法名模式 参数模式 必选
 */
@Aspect
public class ExecutionAspect {
	
	@Before("execution(public * *(..))")
	public void toAllPublic(){
		System.out.println("matched the execution(public * *(..))");
	}
	
	@AfterReturning("execution( * *(eat*))")
	public void toSpecialMethodName(){
		System.out.println("matched the execution( * *(eat*))");
	}
	
	@Before("execution(* com.figer.domain.*(..))")
	public void toSpecialClass(){
		System.out.println("matched the execution(* com.figer.domain.*(..))");
	}
	
	@Before("execution(* com.figer.domain.Sellable+.*(..))")
	public void toSpecialInterfaceAndImpl(){
		System.out.println("matched the execution(* com.figer.domain.*(..))");
	}
}
