package com.figer.spring.ioccontext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.figer.domain.User;

@Configuration
public class AnnotationBeansTest {
	@Bean(name="user")
	public User setUser(){
		User user = new User();
		user.setUserId(1003);
		user.setUserName("annotation");
		return user;
	}
}
