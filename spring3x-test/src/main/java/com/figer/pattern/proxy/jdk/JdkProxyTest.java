package com.figer.pattern.proxy.jdk;

import java.lang.reflect.Proxy;

public class JdkProxyTest {
	public static void main(String[] args) {
		Movable car = new Car();
		PerformanceHandler performanceHandler = new PerformanceHandler(car);
		Movable proxyCar = (Movable) Proxy.newProxyInstance(car.getClass().getClassLoader(), car.getClass().getInterfaces(), performanceHandler);
		proxyCar.move();
		proxyCar.stop();
		
		//JDK 代理只支持接口代理，不支持类代理，如下会报错。spring采用CGlib完成类代理
//		Person figer = new Person();
//		performanceHandler = new PerformanceHandler(figer);
//		Person proxyFiger = (Person) Proxy.newProxyInstance(figer.getClass().getClassLoader(), figer.getClass().getInterfaces(), performanceHandler);
//		proxyFiger.eat("rice");
	}
}
