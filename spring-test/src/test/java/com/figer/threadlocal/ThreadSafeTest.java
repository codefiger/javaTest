package com.figer.threadlocal;

import com.figer.entity.User;

public class ThreadSafeTest {
	public static void main(String[] args) {
		User user = new User(1, "figer");
		MyThread myThread = new MyThread(user);
		Thread thread = new Thread(myThread);
		thread.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		user.setId(2);
	}
}
