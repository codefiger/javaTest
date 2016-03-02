package com.figer.container;

import java.util.HashSet;

/**
 *
 * @author figer
 *
 */
public class CollectionTest {
	public static void main(String[] args) {
		System.out.println(new User(1, "user1").equals(new User(1, "user1")));
		testHashSet();
	}
	
	/**
	 * 测试HashSet,使用其做去重需要重写hashCode 以及 equals方法
	 */
	private static void testHashSet(){
		HashSet<User> users = new HashSet<>();
		users.add(new User(1, "user1"));
		users.add(new User(1, "user2"));
		users.add(new User(1, "user3"));
		users.add(new User(1, "user1"));
		
		
		for (User user : users) {
			System.out.println(user);
		}
		
		HashSet<Student> students = new HashSet<>();
		students.add(new Student(1, "student1"));
		students.add(new Student(1, "student2"));
		students.add(new Student(1, "student3"));
		students.add(new Student(1, "student2"));
		
		for (Student student : students) {
			System.out.println(student);
		}
		
	}
}



class Student{
	private int id;
	private String name;
	
	public Student(int id, String name) {
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
	
	@Override
	public String toString() {
		return "id:" + id + ",name:" + name;
	}
	
	@Override
	public boolean equals(Object obj) {
		return true;
	}
	
}

class User{
	private int id;
	private String name;
	
	public User(int id, String name) {
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
	
	@Override
	public String toString() {
		return "id:" + id + ",name:" + name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}else if (obj instanceof User) {
			User user = (User)obj;
			return user.getId() == id && user.getName().equals(name);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return id;
	}
}