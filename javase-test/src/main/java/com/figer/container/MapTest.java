package com.figer.container;

import java.util.HashMap;

/**
 * 主要是hashMap，
 * 1 hash碰撞：两个不同的key通过hash算法得到相同的hashCode
 * 
 * 
 * @author figer
 *
 */
public class MapTest {
	public static void main(String[] args) {
		
		testHashMap();
	}
	
	public static void testHashMap(){
		System.out.println("object:" + new Object().hashCode());
		System.out.println("String:" + "figer".hashCode());
		System.out.println("Integer:" + new Integer(3).hashCode());
		
		HashMap<String, Student> map = new HashMap<String, Student>();
	}
	
	private static void binary(){
		System.out.println(Integer.toBinaryString(-5));
		System.out.println(Integer.toBinaryString(-4));
		System.out.println(Integer.toBinaryString(-3));
		System.out.println(Integer.toBinaryString(-2));
		System.out.println(Integer.toBinaryString(-1));
		System.out.println(Integer.toBinaryString(0));
		System.out.println(Integer.toBinaryString(1));
		System.out.println(Integer.toBinaryString(2));
		System.out.println(Integer.toBinaryString(3));
		System.out.println(Integer.toBinaryString(4));
		System.out.println(Integer.toBinaryString(5));
	}
}
