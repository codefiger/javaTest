package com.figer.spring.resource;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class SpringResourceTest {
	public static void main(String[] args) throws IOException {
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
		
		Resource classpathResource = new ClassPathResource("applicatioin.xml");
		System.out.println(classpathResource.getFilename());
		
	}
}
