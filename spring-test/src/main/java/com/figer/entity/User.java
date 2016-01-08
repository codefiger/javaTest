package com.figer.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.figer.annotation.Description;

public class User {
	private static final Logger LOGGER = LoggerFactory.getLogger(User.class);
	
	private int id;
	private String name;
	
	public User(){}
	
	public User(int id, String name) {
		LOGGER.info("id init by int");
		this.id = id;
		this.name = name;
	}
	
	public User(Integer id, String name){
		LOGGER.info("id init by Integer");
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void hello(){
		LOGGER.info("My name is {}." , name);
	}
	
	@Override
	@Description("my name is toString()....")
	public String toString() {
		return "id:" + id + ",name:" + name;
	}
}
