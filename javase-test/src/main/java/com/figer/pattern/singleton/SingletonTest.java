package com.figer.pattern.singleton;

public class SingletonTest {
	/* 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */  
	private static SingletonTest singletonTest = null;
	
	/* 私有构造器，防止被实例化 */  
	private SingletonTest(){}
	
	public SingletonTest getInstance(){
		if (null == singletonTest) {
			return new SingletonTest();
		}else{
			return singletonTest;
		}
		
	}
}
