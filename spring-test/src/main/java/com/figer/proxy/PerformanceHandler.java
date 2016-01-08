package com.figer.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PerformanceHandler implements InvocationHandler{
	private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceHandler.class);

	private Object target;
	
	public PerformanceHandler(Object target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		long starttime = System.currentTimeMillis();
		LOGGER.info("starttime:{}", starttime);
		Object obj = method.invoke(target, args);
		LOGGER.info("total:{}ms", System.currentTimeMillis() - starttime);
		return obj;
	}
}
