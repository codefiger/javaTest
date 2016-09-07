package com.figer.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ProducerConsumerTest {
		
		public static void main(String[] args) throws Exception{
			threadPoolTest();
		}
		
		private static void threadPoolTest() throws Exception{
			long startTime = System.currentTimeMillis();
			ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(10);
			
			Producer producer = new Producer(blockingQueue);
			Thread producerT1 = new Thread(producer, "Producer");
			
			int corePoolSize = Runtime.getRuntime().availableProcessors() * 2;
			ThreadPoolExecutor executor = 
					new ThreadPoolExecutor(corePoolSize, corePoolSize, 101, TimeUnit.SECONDS, new ArrayBlockingQueue(100));
			Consumer consumer = new Consumer(blockingQueue);
			executor.prestartAllCoreThreads();
			producerT1.start();
			executor.execute(consumer);
			executor.execute(consumer);
			executor.execute(consumer);
			executor.execute(consumer);
			executor.execute(consumer);
			executor.execute(consumer);
			
			producerT1.join();
			System.out.println("total use:" + (System.currentTimeMillis() - startTime));
		}
		
		private static void test() throws Exception{
			long startTime = System.currentTimeMillis();
			//ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(10);
			ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(10);

			Producer producer = new Producer(blockingQueue);
			Thread producerT1 = new Thread(producer, "Producer");
			
			Consumer consumer = new Consumer(blockingQueue);
			Thread consumerT1 = new Thread(consumer, "Consumer1");
			producerT1.start();
			consumerT1.start();
			
			producerT1.join();
			consumerT1.join();
			System.out.println("total use:" + (System.currentTimeMillis() - startTime));
		}
		
		
}

class Producer implements Runnable{
	BlockingQueue<String> queue ;

	public Producer(BlockingQueue<String> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				queue.put("product" + i);
				System.out.println(Thread.currentThread().getName() + "生产一个产品" + i + "放在队列中.");
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Consumer implements Runnable{
	BlockingQueue<String> queue;
	
	public Consumer(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		for(;;){
			try {
				long statTime = System.currentTimeMillis();
				String str = queue.poll(3, TimeUnit.SECONDS);
				if (System.currentTimeMillis() - statTime >= 3000) {
					break;
				}
				System.out.println(Thread.currentThread().getName() + "消费一个产品:" + str);
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
