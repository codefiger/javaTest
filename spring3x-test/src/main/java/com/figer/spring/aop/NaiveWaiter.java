package com.figer.spring.aop;

public class NaiveWaiter implements Waiter {

	@Override
	public void greetTo(String name) {
		System.out.println("waiter greet to " + name);
	}

	@Override
	public void serveTo(String name) {
		System.out.println("waiter serve to " + name);
	}

}
