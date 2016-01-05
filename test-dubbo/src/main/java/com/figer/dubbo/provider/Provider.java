package com.figer.dubbo.provider;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Provider {
	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"dubbo/applicationContext-provider.xml"});  
        context.start();  
        System.in.read(); // 为保证服务一直开着，利用输入流的阻塞来模拟 
	}
}
