package com.figer.annotation;

import com.figer.entity.User;

public class AnnotationTest {
	public static void main(String[] args) throws Exception {
		User figer = new User(1, "figer");
		
		//利用反射拿到注解信息
		Description description = figer.getClass().getDeclaredMethod("toString", null).getAnnotation(Description.class);
		System.out.println(description.value());
	}
}
