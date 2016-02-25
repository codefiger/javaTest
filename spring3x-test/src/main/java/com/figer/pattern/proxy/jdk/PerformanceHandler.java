package com.figer.pattern.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PerformanceHandler implements InvocationHandler {
	private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceHandler.class);
	
	private Object target;
	public PerformanceHandler(Object target ) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		long startTime = System.currentTimeMillis();
		LOGGER.info("start time:{}", startTime);
		Object returnObj = method.invoke(target, args);
		LOGGER.info("total use time:{}", System.currentTimeMillis() - startTime);
		return returnObj;
	}

}
