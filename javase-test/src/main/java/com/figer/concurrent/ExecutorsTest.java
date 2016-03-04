package com.figer.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecutorsTest {
	public static void main(String[] args) {
		final Executor executor = Executors.newFixedThreadPool(4);
		executor.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
			}
		});
		
		int count = ((ThreadPoolExecutor)executor).prestartAllCoreThreads();
		System.out.println(count);
		
	}
}
