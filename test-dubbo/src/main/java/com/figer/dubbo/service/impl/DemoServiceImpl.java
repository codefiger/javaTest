package com.figer.dubbo.service.impl;

import com.figer.dubbo.service.DemoService;

public class DemoServiceImpl implements DemoService{
	@Override
	public void sayHello(){
		System.out.println("Hello world!");
	}
}
