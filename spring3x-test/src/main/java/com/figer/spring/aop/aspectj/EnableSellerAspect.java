package com.figer.spring.aop.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

import com.figer.domain.Sellable;
import com.figer.domain.SmartSeller;

@Aspect
public class EnableSellerAspect {
	@DeclareParents(value="com.figer.spring.aop.NaiveWaiter",defaultImpl=SmartSeller.class)
	public Sellable sellable;
}
