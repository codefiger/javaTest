package com.figer.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerTest {
		
		public static void main(String[] args) {
			ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(10);
			
			Producer producer = new Producer(blockingQueue);
			new Thread(producer, "Producer").start();
			
			Consumer consumer = new Consumer(blockingQueue);
			for (int i = 0; i < 3; i++) {
				new Thread(consumer, "Consumer" + i).start();
			}
		}
		
		
}

class Producer implements Runnable{
	BlockingQueue<String> queue ;

	public Producer(BlockingQueue<String> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
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
				String str = queue.take();
				System.out.println(Thread.currentThread().getName() + "消费一个产品:" + str);
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
