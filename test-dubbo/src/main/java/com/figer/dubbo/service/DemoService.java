package com.figer.dubbo.service;

import java.util.List;

import com.figer.dubbo.entity.User;

public interface DemoService {
	public void sayHello();
	public List<User> queryAllUsers();
}
