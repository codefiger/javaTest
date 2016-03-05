package com.figer.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
	public static void main(String[] args) {
		ThreadPoolExecutor threadPoolExecutor = null;
		Executor executor = null;
		try {
			//手动创建，与楼下一比...
			threadPoolExecutor = 
					new ThreadPoolExecutor(3, 6, 1000, TimeUnit.NANOSECONDS, new ArrayBlockingQueue(10));
			threadPoolExecutor.prestartAllCoreThreads();//启动基本线程，此处我配置的是三个，所谓会新建3个线程
			//静态工厂方法创建线程池
			executor = Executors.newFixedThreadPool(3);
			
			Future<String> future = threadPoolExecutor.submit(new Callable<String>() {

				@Override
				public String call() throws Exception {
					return "success";
				}
			});
			
			//阻塞等待线程执行完毕
			System.out.println(future.get());
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (threadPoolExecutor != null) {
				threadPoolExecutor.shutdown();
			}
		}
	}
}	
