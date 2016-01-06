package com.figer.dubbo.consumer;

import java.io.IOException;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.figer.dubbo.entity.User;
import com.figer.dubbo.service.DemoService;


public class Consumer {
	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "dubbo/applicationContext-consumer.xml" });  
        context.start();  
  
        DemoService demoService = (DemoService) context.getBean("demoService"); //  
        demoService.sayHello(); 
        
        List<User> users = demoService.queryAllUsers();
        for (User user : users) {
			System.out.println(user);
		}
  
        System.in.read();  
	}
}
