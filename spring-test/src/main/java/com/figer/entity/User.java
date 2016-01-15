package com.figer.entity;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.figer.annotation.Description;

public class User {
	private static final Logger LOGGER = LoggerFactory.getLogger(User.class);
	
	private int id;
	private String name;
	private Company company;
	private Date creteDate;
	
	public User(){}
	
	public User(int id, String name) {
		//LOGGER.info("id init by int");
		this.id = id;
		this.name = name;
	}
	
	public User(Integer id, String name){
		LOGGER.info("id init by Integer");
		this.id = id;
		this.name = name;
	}
	
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public  int getId() {
		return id;
	}
	public void  setId(int id) {
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

	public Date getCreteDate() {
		return creteDate;
	}

	public void setCreteDate(Date creteDate) {
		this.creteDate = creteDate;
	}
	
	
}
