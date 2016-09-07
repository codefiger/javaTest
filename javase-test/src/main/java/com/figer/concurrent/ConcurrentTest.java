package com.figer.concurrent;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveAction;

import org.junit.Test;

public class ConcurrentTest {

	@Test
	public void testCompletionService() throws Exception{
		@SuppressWarnings("rawtypes")
		final CompletionService<?> completionService = new ExecutorCompletionService(
				Executors.newFixedThreadPool(4));
		completionService.submit(new Callable() {

			@Override
			public Object call() throws Exception {
				return "hello world";
			}
		});
		
		Future future = completionService.take();
		System.out.println(future.get());
	}
	
	@Test
	public void testConcurrentHashMap(){
		ConcurrentMap<Integer, String> map = new ConcurrentHashMap<Integer, String>();
		String key = map.put(1, "figer");
		System.out.println("key:" + key);
		
		System.out.println(map.put(1, "aa"));
		
		String key2 = map.replace(1, "tom");
		System.out.println("key2:" + key2);
	}
	
	@Test
	public void testConcurrentLinkedQueue(){
		ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();
		queue.add("figer 1");
		queue.add("tom 2");
		queue.add("sam 3");
		
		for (Object object : queue) {
			System.out.println(object);
		}
		
		System.out.println("------");
		System.out.println(queue.poll());
		
	}
	
	@Test
	public void forkAndJoin(){
		int[] array = {3,6,1,19,4,7,100,12,4};
		MaxResovler resovler = new MaxResovler(array, 0, array.length);
		
		ForkJoinPool pool = new ForkJoinPool(1);
		pool.invoke(resovler);
		
		System.out.println(resovler.result);
	}
	
	@Test
	public void hashMapInConcurrent() throws Exception{
		final HashMap<String, String> map = new HashMap<String, String>();
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				for(int i = 0;i < 10000;i ++){
					new Thread(new Runnable() {
						
						@Override
						public void run() {
							map.put(UUID.randomUUID().toString(), "");
						}
					}, "ftf" + i).start();
				}
			}
		});
		
		thread.start();
		thread.join();
	}

}

class MaxResovler extends RecursiveAction{
	public int result,start,end;
	private int[] array;
	
	public MaxResovler(int[] array, int start, int end) {
		this.array = array;
		this.start = start;
		this.end = end;
	}

	@Override
	protected void compute() {
		if(end - start == 1){
			result = array[start];
		}else{
			int mid = (end - start)/2;
			MaxResovler resovlerLeft = new MaxResovler(array, start, mid);
			MaxResovler resovlerRight = new MaxResovler(array, mid, end);
			invokeAll(resovlerLeft, resovlerRight);
			result = Math.max(resovlerLeft.result, resovlerRight.result);
		}
		
	}
}
