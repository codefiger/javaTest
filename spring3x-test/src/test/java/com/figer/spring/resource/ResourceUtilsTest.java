package com.figer.spring.resource;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

public class ResourceUtilsTest {
	public static void main(String[] args) throws IOException {
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		//classpath*:   classpath: 区别第一个会匹配所有jar，具体看代码
		Resource[] resources = resolver.getResources("classpath*:**");
		for (Resource resource : resources) {
			System.out.println(resource.getDescription());
		}
	}
}
