package com.figer.dubbo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.figer.dubbo.entity.User;
import com.figer.dubbo.service.DemoService;

public class DemoServiceImpl implements DemoService{
	@Override
	public void sayHello(){
		System.out.println("Hello world!");
	}

	@Override
	public List<User> queryAllUsers() {
		List<User> users = new ArrayList<>();
		User a = new User().setName("figer").setAge(11);
		
		for(int i = 0; i < 6; i++){
			users.add(a);
		}
		return users;
	}
}
