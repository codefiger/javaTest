package com.figer.threadlocal;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 生产者/消费者模式
 * @author peng.zhang
 * 0  什么是锁对象？ synchronized(锁){临界区代码}   
 * 		或 public synchronized Object getEgg(){..}这个方法就是锁对象
 * 		或 public static synchronized void staticMethod(){} 整个类就是锁对象
 * 1  每个锁对象都有两个队列，一个是就绪队列，一个是阻塞队列，就绪队列存储了将要获得锁的线程，阻塞队列存储了被阻塞的线程
 * 2  当一个被线程被唤醒 (notify)后，才会进入到就绪队列，等待cpu的调度
 * 
 * 一个线程执行临界区代码过程如下：
 * 	1 获得同步锁
 * 	2 清空工作内存
 * 	3 从主存拷贝变量副本到工作内存
 * 	4 对这些变量计算
 * 	5 将变量从工作内存写回到主存
 * 	6 释放锁
 *
 */
public class Plate {
	private static final Logger LOGGER = LoggerFactory.getLogger(Plate.class);
	private List<Object> eggs = new ArrayList<>();
	
	public synchronized Object getEgg(){
		while(eggs.isEmpty()){
			try {
				LOGGER.info("get egg.Plate is empty,waiting....");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		Object egg = eggs.get(0);
		LOGGER.info("get a egg:{}", egg);
		eggs.clear();
		notify();
		return egg;
	}
	
	public synchronized void putEgg(Object egg){
		while (!eggs.isEmpty()) {
			try {
				wait();
				LOGGER.info("put egg.Plate has egg,waiting....");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		eggs.add(egg);
		LOGGER.info("put a egg:{}", egg);
		notify();
	}
	
	static class GetEggThread implements Runnable{
		private Plate plate;
		
		public GetEggThread(Plate plate){
			this.plate = plate;
		}
		
		public void run(){
			for (int i = 0; i < 6; i++) {
				plate.getEgg();
			}
		}
	}
	
	static class PutEggThread implements Runnable{
		private Plate plate;
		
		public PutEggThread(Plate plate){
			this.plate = plate;
		}
		
		public void run(){
			Object egg = new Object();
			for (int i = 0; i < 5; i++) {
				plate.putEgg(egg);
			}
		}
	}
	
	
	public static void main(String[] args) {
		Plate plate = new Plate();
		Thread putEggThread = new Thread(new PutEggThread(plate));
		Thread getEggThread = new Thread(new GetEggThread(plate));
		
		getEggThread.start();
		putEggThread.start();
	}
	
}
