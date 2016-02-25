package com.figer.pattern.oberver;

public class ObserverImpl implements Oberver{

	@Override
	public void update() {
		System.out.println("我是观察者，知悉了主题修改，做出修改。");
	}

}
