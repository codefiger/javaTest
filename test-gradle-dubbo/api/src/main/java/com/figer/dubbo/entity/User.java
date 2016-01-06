package com.figer.dubbo.entity;

import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = 5297441636916122995L;
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public User setName(String name) {
		this.name = name;
		return this;
	}
	public int getAge() {
		return age;
	}
	public User setAge(int age) {
		this.age = age;
		return this;
	}
	@Override
	public String toString() {
		return "my name is " + name + ",and age " + age;
	}
}
