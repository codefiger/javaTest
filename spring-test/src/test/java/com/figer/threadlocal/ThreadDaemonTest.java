package com.figer.threadlocal;

import com.figer.entity.User;

public class ThreadDaemonTest {
	public static void main(String[] args) throws InterruptedException {
		User user1 = new User(1, "user1");
		User user2 = new User(2, "user2");
		Thread thread1 = new Thread(new MyThread(user1), "thread1");
		Thread thread2 = new Thread(new MyThread(user2), "thread2");
		
		thread1.setDaemon(true);//The Java Virtual Machine exits when the only threads running are all daemon threads
		thread2.setDaemon(true);
		thread1.start();
		thread2.start();
		
        System.out.println("main thread is over");
	}
}


