package com.figer.pattern.singleton;

public class InnerClassSingleton {
	/* 私有构造器，防止被实例化 */  
	private InnerClassSingleton(){}  
	
	/**
	 * JVM内部的机制能够保证当一个类被加载的时候，这个类的加载过程是线程互斥的
	 */
	private static class SingletonFactory{
		/* 持有私有静态实例，防止被引用，目的是实现延迟加载 */
		private static InnerClassSingleton singleton = new InnerClassSingleton();
	}
	
	public InnerClassSingleton getInstance(){
		return SingletonFactory.singleton;
	}
}
