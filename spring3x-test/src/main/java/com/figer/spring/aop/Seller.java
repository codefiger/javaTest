package com.figer.spring.aop;

public class Seller{
	public void greetTo(String name) {
		System.out.println("seller greet to " + name);
	}

	public void serveTo(String name) {
		System.out.println("seller serve to " + name);
	}
}
