package com.figer.container;

import java.util.LinkedList;
/**
 * LinkedList实现Stack
 * @author figer
 *
 * @param <T>
 */
public class MyStack<T> {
	private LinkedList<T> linkedList = new LinkedList<T>();
	
	public void push(T t){
		linkedList.addFirst(t);
	}
	
	public T pop(){
		return linkedList.removeFirst();
	}
	
	public boolean isEmpty(){
		return linkedList.isEmpty();
	}
	
	public static void main(String[] args) {
		MyStack<String> stringStack = new MyStack<String>();
		stringStack.push("one");
		stringStack.push("two");
		stringStack.push("three");
		
		while(!stringStack.isEmpty()){
			System.out.println(stringStack.pop());
		}
	}
}
