package com.figer.pattern.proxy;


import java.lang.reflect.Proxy;

public class JDKProxyTest {
	public static void main(String[] args) {
		IRemoteService remoteService = new RemoteService();
		PerformanceHandler performanceHandler = new PerformanceHandler(remoteService);
    IRemoteService proxy = (IRemoteService) Proxy.newProxyInstance(
				remoteService.getClass().getClassLoader(),
				remoteService.getClass().getInterfaces(),
				performanceHandler);
		
		proxy.create();
	}
}
