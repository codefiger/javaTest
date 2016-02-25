package com.figer.pattern.proxy.cglib;

import com.figer.pattern.proxy.jdk.Person;

public class CglibTest {
	public static void main(String[] args) {
		CglibProxy cglibProxy = new CglibProxy();
		Person person = (Person) cglibProxy.getProxy(Person.class);
		person.eat("rice");
		
	}
}
