package com.figer.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectIOTest {
	public static void main(String[] args) throws Exception{
		String fileName = "/Users/figer/myspace/test/objectFile";
//		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(fileName));
//		
//		Car car = new Car(1, "file");
//		
//		output.writeObject(car);
//		
//		output.close();
		
		ObjectInputStream input = new ObjectInputStream(new FileInputStream(fileName));
		Car car = (Car)input.readObject();
		System.out.println(car.getName());
		input.close();
	}
}

class Car implements Serializable{
	private static final long serialVersionUID = -6016525698194935121L;
	
	private int id;
	private String name;
	
	public Car(int id, String name) {
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
	
	
}
