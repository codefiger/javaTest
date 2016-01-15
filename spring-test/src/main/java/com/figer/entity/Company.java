package com.figer.entity;

public class Company {
	private int id;
	private String name;
	
	public Company() {
	}
	
	public Company(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public Company setId(int id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Company setName(String name) {
		this.name = name;
		return this;
	}
	
	@Override
	public String toString() {
		return "id:" + id + ",name:" + name;
	}
}
