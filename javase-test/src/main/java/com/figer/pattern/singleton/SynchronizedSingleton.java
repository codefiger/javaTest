package com.figer.pattern.singleton;

public class SynchronizedSingleton {
	private static SynchronizedSingleton singleton = null;
	
	private SynchronizedSingleton(){}
	
	public synchronized SynchronizedSingleton getInstance(){
		if (null == singleton) {
			return new SynchronizedSingleton();
		}else{
			return singleton;
		}
	}
}
