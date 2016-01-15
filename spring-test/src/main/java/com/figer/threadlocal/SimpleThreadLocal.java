package com.figer.threadlocal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 模拟JDK所提供的ThreadLocal类在实现思路上是非常相近的
 * @author peng.zhang
 *
 */
public class SimpleThreadLocal {

	private final Map map = Collections.synchronizedMap(new HashMap());
	
	public Object get(){
		Object obj = map.get(Thread.currentThread());
		
		if(obj == null){
			obj = intialValue();
			map.put(Thread.currentThread(), obj);
		}
		
		return obj;
	}
	
	public void set(Object newValue){
		map.put(Thread.currentThread(), newValue);
	}
	
	public void remove(){
		map.remove(Thread.currentThread());
	}
	
	protected Object intialValue(){
		return null;
	}
	
}
