package com.figer.spring.resource;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.FileCopyUtils;

public class SpringResourceTest {
	public static void main(String[] args) throws IOException {
		//FileSystemResource 访问资源
		String filePath = "/Users/figer/Pictures/luffy.jpeg";
		Resource fileResource = new FileSystemResource(filePath);
		Resource relativeResource = fileResource.createRelative("springResourceRelativeTest");
		relativeResource.getFile().createNewFile();
		
		InputStream luffyStream = fileResource.getInputStream();
		System.out.println(fileResource.getFilename());
		System.out.println(fileResource.getDescription());
		System.out.println(fileResource.getURL());
		System.out.println(fileResource.getURI());
		
		System.out.println(luffyStream.read());
		luffyStream.close();
		
		//ClassPathResource 访问资源
		Resource classpathResource = new ClassPathResource("applicatioin.xml");
		System.out.println(classpathResource.getFilename());
		
		//使用EncodedResource对资源进行编码
		EncodedResource encodedResource = new EncodedResource(fileResource, "UTF-8");
		String content = FileCopyUtils.copyToString(encodedResource.getReader());
		System.out.println(content);
	}
}
