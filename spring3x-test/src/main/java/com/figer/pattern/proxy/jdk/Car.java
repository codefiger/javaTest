package com.figer.pattern.proxy.jdk;

public class Car implements Movable {

	@Override
	public void move() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void stop() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void doSomething(){
		System.out.println("saving car infomation to db.");
		System.out.println("doing things,meet some trouble!");
		throw new RuntimeException("缺少有效信息...");
	}

}
