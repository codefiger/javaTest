package com.figer.reflect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.figer.entity.User;

public class SimpleReflectTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(User.class);
	
	public static void main(String[] args) throws Exception {
		Class<?> userClass = Class.forName("com.figer.entity.User");
		LOGGER.info(userClass.getName());
		
		User user = (User)userClass.getConstructor(Integer.class, String.class).newInstance(1, "figer");
		LOGGER.info(user.toString());
		
		User userByInt = (User)userClass.getConstructor(int.class, String.class).newInstance(2, "figer");
		LOGGER.info(userByInt.getName());
		
		//通过类加载器获取user对象
		ClassLoader currentClassLoader = Thread.currentThread().getContextClassLoader();
		Class<?> loaderClass = currentClassLoader.loadClass("com.figer.entity.User");
		LOGGER.info(loaderClass.getName());
	}
}
