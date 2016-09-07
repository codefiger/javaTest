package com.figer.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutureTest {
	public static void main(String[] args) throws Exception{
		final Future future = Executors.newCachedThreadPool().submit(new Callable() {

			@Override
			public Object call() throws Exception {
				Thread.sleep(4000);
				return 2;
			}
		});
		
		try {
			//blocked until some result is available 
			System.out.println(future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		System.out.println("-----");
		
		
		
		//or 
		FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {

			@Override
			public String call() throws Exception {
				return "hello world";
			}
		});
		
		Thread thread = new Thread(futureTask);
		thread.start();
		System.out.println(futureTask.get());
	}
}
