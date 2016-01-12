package com.figer.threadlocal;

import com.figer.entity.User;

/**
 *Thread API 包含了等待另一个线程完成的方法：join() 方法。当调用 Thread.join() 时，调用线程将阻塞，直到目标线程完成为止。
 * @param args
 * @throws Exception
 */
public class ThreadJoinTest {
	public static void main(String[] args) throws InterruptedException {
		User user1 = new User(1, "user1");
		User user2 = new User(2, "user2");
		Thread thread1 = new Thread(new MyThread(user1), "thread1");
		Thread thread2 = new Thread(new MyThread(user2), "thread2");
		
		thread1.start();
		thread2.start();
		
		System.out.println("---1");
		thread1.join();//调用线程将阻塞，直到目标线程完成为止
		System.out.println("---2");
		thread2.join();
        System.out.println("main thread is over");
	}
}


