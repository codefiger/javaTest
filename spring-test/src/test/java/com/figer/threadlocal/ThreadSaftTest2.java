package com.figer.threadlocal;

import java.util.concurrent.TimeUnit;

public class ThreadSaftTest2 {
	private static boolean finished;//不加volatile修饰会导致线程永远不会结束,hotspot jvm编译优化了代码，把finished提升为局部变量...
	
	
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new Runnable() {
			int i = 0;
			@Override
			public void run() {
				while(!finished){
					i++;
				}
			}
		});
		
		t.start();
		
		TimeUnit.SECONDS.sleep(1);
		finished = true;
		System.out.println("main thread end!");
	}
}
