package com.figer.threadlocal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadSafeTest {
	private static final int TIMES = 10000;
	private static final Logger LOGGER = LoggerFactory.getLogger(ThreadSafeTest.class);
	
	public static void main(String[] args) throws InterruptedException {
		Account account = new Account(10000);
		Thread addThread = new Thread(new AddThread(account), "add");
		Thread withdrawThread = new Thread(new WithdrawThread(account), "withdraw");
		
		long starttime = System.currentTimeMillis();
		
		addThread.start();
		withdrawThread.start();
		addThread.join();
		withdrawThread.join();
		System.out.println(account.getBalance());
		LOGGER.info("total {} ms", System.currentTimeMillis() - starttime);
	}
	
	static class Account{
		//使用共享标志，声明成volatile，保证并发环境的执行有序性 
		private int balance;
		
		public Account(int balance) {
			this.balance = balance;
		}
		
		public int getBalance() {
			return this.balance;
		}

		public synchronized int add(int num){
			return this.balance += num;
		}
		
		public synchronized int withdraw(int num){
			return this.balance -= num;
		}
	}
	
	static class AddThread implements Runnable{
		private Account account;

		public AddThread(Account account) {
			this.account = account;
		}
		@Override
		public void run() {
			for(int i=0;i<TIMES;i++){
				LOGGER.info("add " + i);
				account.add(20);
			}
		}
		
	}
	
	static class WithdrawThread implements Runnable{
		private Account account;

		public WithdrawThread(Account account) {
			this.account = account;
		}
		@Override
		public void run() {
			for(int i=0;i<TIMES;i++){
				LOGGER.info("withdraw " + i);
				account.withdraw(20);
			}
		}
		
	}
}


