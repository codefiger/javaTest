package com.figer.dubbo.provider;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Provider {
	private static final Logger logger = LoggerFactory.getLogger(Provider.class);
	
	public static void main(String[] args) throws IOException {
		logger.info("test log!");
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"dubbo/applicationContext-provider.xml"});  
        context.start();  
        System.in.read(); // 为保证服务一直开着，利用输入流的阻塞来模拟 
	}
}
