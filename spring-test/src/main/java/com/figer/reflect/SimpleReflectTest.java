package com.figer.reflect;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.figer.entity.User;

public class SimpleReflectTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(User.class);
	
	public static void main(String[] args) throws Exception {
	  User loginUser = new User();
    System.out.println(loginUser.getClass().getName());

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
		
		//如下方法，如果一些逻辑反复出现，可用反射处理
		doThreeTimes("hello", new User(1, "Tom"), null, null);



	}
	
	private static Object doThreeTimes(String methodName, Object target, Object[] args, Class<?>... classParams) throws Exception{
		Method method = target.getClass().getDeclaredMethod(methodName, classParams);
		Object result = null;
		if (null != method) {
			for(int i = 0; i < 3; i++){
				result = method.invoke(target, args);
			}
		}
		return result;
	}
}
