package com.figer.container;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;


/**
 *
 * @author figer
 *
 */
public class CollectionTest {
	public static void main(String[] args) {
		//System.out.println(new User(1, "user1").equals(new User(1, "user1")));
		//testHashSet();
		
		//testTreeSet();
		
		//testSort();
		
		removeElement();
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
	
	/**
	 * 可排序的Set集合
	 */
	private static void testTreeSet(){
		TreeSet<Student> treeSet = new TreeSet<>();
		treeSet.add(new Student(2, "sam"));
		treeSet.add(new Student(1, "figer"));
		treeSet.add(new Student(2, "tom"));
		treeSet.add(new Student(2, "jim"));
		
		
		Iterator<Student> car = treeSet.iterator();
		while (car.hasNext()) {
			Student student = car.next();
			System.out.println(student);
		}
	}
	
	/**
	 * 1 类实现comparable接口
	 * 2 使用comparator比较器
	 */
	private static void testSort(){
		List<Student> students = new ArrayList<>();
		students.add(new Student(1, "student1"));
		students.add(new Student(1, "student2"));
		students.add(new Student(1, "student3"));
		students.add(new Student(1, "student2"));
		
		printContainer(students);
		
		//1 类实现comparable接口
		Collections.sort(students);
		
		System.out.println("-------");
		printContainer(students);
		
		List<Student> students2 = new ArrayList<>();
		students2.add(new Student(1, "student1"));
		students2.add(new Student(1, "student2"));
		students2.add(new Student(1, "student3"));
		students2.add(new Student(1, "student2"));
		
		//2 使用comparator比较器
		//为了简化，没有做逻辑严密的判断，比如判空
		Collections.sort(students2, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				int result = o1.getId() > o2.getId() ? 1 :(o1.getId() == o2.getId() ? 0 : -1);
				if (result == 0) {
					return o1.getName().compareTo(o2.getName());
				}
				return result;
			}
		});
		System.out.println("---------");
		printContainer(students2);
	}
	
	/**
	 * 使用Iterator进行遍历集合时，不能直接从集合中移除元素，使用iterator的remove方法
	 */
	private static void removeElement(){
		List<Student> students = new ArrayList<>();
		students.add(new Student(1, "student1"));
		students.add(new Student(1, "student2"));
		students.add(new Student(1, "student3"));
		students.add(new Student(1, "student2"));
		printContainer(students);
		
		Iterator<Student> car = students.iterator();
		while (car.hasNext()) {
			Student student = car.next();
			if (student.getName().equals("student2")) {
				car.remove();
			}
		}
		
		System.out.println("-----");
		printContainer(students);
	}
	
	private static void printContainer(Iterable iterable){
		for (Object object : iterable) {
			System.out.println(object);
		}
	}
}



class Student implements Comparable<Student>{
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

	//为了简化，没有做逻辑严密的判断，比如判空
	@Override
	public int compareTo(Student o) {
		int result = id > o.getId() ? 1 :(id == o.getId() ? 0 : -1);
		if (result == 0) {
			return name.compareTo(o.getName());
		}
		return result;
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