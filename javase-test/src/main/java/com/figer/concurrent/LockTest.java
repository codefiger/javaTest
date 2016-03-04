package com.figer.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
	public static void main(String[] args) throws Exception{
		final Lock lock = new ReentrantLock();
		lock.lock();
		
		
		lock.lockInterruptibly();
		
		
	}
}
