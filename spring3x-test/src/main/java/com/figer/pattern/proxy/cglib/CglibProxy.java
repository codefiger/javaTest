package com.figer.pattern.proxy.cglib;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {
	private static final Logger LOGGER = LoggerFactory.getLogger(CglibProxy.class);
	private Enhancer enhancer = new Enhancer();
	
	public Object getProxy(Class superclass){
		enhancer.setSuperclass(superclass);
		enhancer.setCallback(this);
		return enhancer.create();
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		long startTime = System.currentTimeMillis();
		LOGGER.info("start time:{}", startTime);
		Object result = proxy.invokeSuper(obj, args);
		LOGGER.info("total use time:{}", System.currentTimeMillis() - startTime);
		return result;
	}

}
