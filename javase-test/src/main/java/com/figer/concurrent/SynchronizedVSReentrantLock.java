package com.figer.concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedVSReentrantLock {

	public static void main(String[] args) throws InterruptedException {
		synchronizedTest();
	}

	/**
	 * 可以中断一个正在等候获得锁的线程。实现了等待锁的时候，5秒没有获取到锁，中断等待，线程继续做其它事情
	 * @throws InterruptedException
	 */
	private static void reentrantLockTest() throws InterruptedException{
		BufferInterruptibly buff = new BufferInterruptibly();

		final NewWriter writer = new NewWriter(buff);
		final NewReader reader = new NewReader(buff);

		writer.start();
		Thread.sleep(1000);
		reader.start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				long start = System.currentTimeMillis();
				for (;;) {
					if (System.currentTimeMillis() - start > 5000) {
						System.out.println("不等了，尝试中断");
						reader.interrupt();
						break;
					}
				}
				
				System.out.println("中断结束");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("当前程序线程数：" + Thread.activeCount());
			}
		}).start();
		
		System.out.println("当前程序线程数：" + Thread.activeCount());
	}

	/**
	 *
	 * @Description: 不能实现等待锁的线程结束。等待锁的时候，5秒没有获取到锁，中断等待，线程继续做其它事情。 输出：
	 *               开始往这个buff写入数据… 不等了，尝试中断 中断结束
	 */
	private static void synchronizedTest() throws InterruptedException {
		Buffer buff = new Buffer();
		final Writer writer = new Writer(buff);
		final Reader reader = new Reader(buff);

		writer.start();
		Thread.sleep(1000);
		reader.start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				long start = System.currentTimeMillis();
				for (;;) {
					// 等5秒钟去中断读
					if (System.currentTimeMillis() - start > 5000) {
						System.out.println("不等了，尝试中断");
						reader.interrupt();
						break;
					}

				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("中断结束");
				System.out.println("当前程序线程数：" + Thread.activeCount());
			}
		}).start();

		System.out.println("当前程序线程数：" + Thread.activeCount());
	}

	public static class Writer extends Thread {

		private Buffer buff;

		public Writer(Buffer buff) {
			this.buff = buff;
		}

		@Override
		public void run() {
			buff.write();
			System.out.println("写结束");
		}

	}

	public static class Reader extends Thread {

		private Buffer buff;

		public Reader(Buffer buff) {
			this.buff = buff;
		}

		@Override
		public void run() {

			buff.read();// 一直阻塞

			System.out.println("读结束");

		}

	}

	public static class Buffer {

		private Object lock;

		public Buffer() {
			lock = this;
		}

		public void write() {
			synchronized (lock) {
				long startTime = System.currentTimeMillis();
				System.out.println("开始往这个buff写入数据…");
				for (;;)// 模拟要处理很长时间
				{
					if (System.currentTimeMillis() - startTime > Integer.MAX_VALUE)
						break;
				}
				System.out.println("终于写完了");
			}
		}

		public void read() {
			synchronized (lock) { // 一直阻塞
				System.out.println("从这个buff读数据");
			}
		}
	}

	public static class BufferInterruptibly {

		private ReentrantLock lock = new ReentrantLock();

		public void write() {
			lock.lock();
			try {
				long startTime = System.currentTimeMillis();
				System.out.println("开始往这个buff写入数据…");
				for (;;)// 模拟要处理很长时间
				{
					if (System.currentTimeMillis() - startTime > Integer.MAX_VALUE)
						break;
				}
				System.out.println("终于写完了");
			} finally {
				lock.unlock();
			}
		}

		public void read() throws InterruptedException {
			lock.lockInterruptibly();// 注意这里，可以响应中断，抛出中断异常。
			try {
				System.out.println("从这个buff读数据");
			} finally {
				lock.unlock();
			}
		}
	}

	public static class NewWriter extends Thread {

		private BufferInterruptibly buff;

		public NewWriter(BufferInterruptibly buff) {
			this.buff = buff;
		}

		@Override
		public void run() {
			buff.write();
			System.out.println("写结束");
		}

	}

	public static class NewReader extends Thread {

		private BufferInterruptibly buff;

		public NewReader(BufferInterruptibly buff) {
			this.buff = buff;
		}

		@Override
		public void run() {

			try {
				buff.read();// 可以收到中断的异常，从而有效退出
			} catch (InterruptedException e) {
				System.out.println("我不读了");
			}

			System.out.println("读结束，去做其它事情");

		}

	}
}
