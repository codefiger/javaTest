package com.figer.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class QueueTest {
	public static void main(String[] args) {
		ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(3);
		LinkedBlockingQueue<String> linkedBlockingDeque = new LinkedBlockingQueue<>();
		
		for(int i  = 0 ;i < 10; i ++){
			linkedBlockingDeque.add("str:" + i);
		}
		System.out.println(linkedBlockingDeque.size());

		
		for(int i  = 0 ;i < 10; i ++){
			arrayBlockingQueue.add("str:" + i);
		}
		System.out.println(arrayBlockingQueue.size());
		
	}
}
