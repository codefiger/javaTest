package com.figer.proxy;

import java.lang.reflect.Proxy;

import com.figer.services.Movable;
import com.figer.services.impl.Car;

public class JDKProxyTest {
	public static void main(String[] args) {
		Movable movable = new Car();
		PerformanceHandler performanceHandler = new PerformanceHandler(movable);
		Movable proxy = (Movable) Proxy.newProxyInstance(
				movable.getClass().getClassLoader(), 
				movable.getClass().getInterfaces(), 
				performanceHandler);
		
		proxy.move();
	}
}
