package com.figer.concurrent;

/**
 * 在JAVA环境下 ReentrantLock 和synchronized 都是 可重入锁
 * 
 * 可重入锁，也叫做递归锁，指的是同一线程 外层方法获得锁之后 ，内层递归方法仍然有获取该锁的代码，但不受影响。
 * @author figer
 *
 */
public class LockTest {
	public static void main(String[] args) throws Exception{
		Thread thread = new Thread(new MyThread(new LockTest()));
		
		thread.start();
		thread.join();
		
	}
	
	public  void increase(WarpInt warpInt){
		synchronized(warpInt){
			warpInt.count ++;
			innerFun(warpInt);
		}
	}
	
	private  void innerFun(WarpInt warpInt){
		synchronized(warpInt){
			warpInt.count ++;
		}
	}
	
	
}

class WarpInt{
	int count = 0;
}

class MyThread implements Runnable{
	
	LockTest lockTest;
	
	public MyThread(LockTest lockTest) {
		this.lockTest = lockTest;
	}

	@Override
	public void run() {
		WarpInt warpInt = new WarpInt();
		lockTest.increase(warpInt);
		System.out.println(warpInt.count);
	}}