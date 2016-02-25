package com.figer.pattern.oberver;

public class ObserverImpl implements Oberver{
	private String  status;

	@Override
	public void update() {
		System.out.println("我是观察者，知悉了主题修改，做出修改。");
	}

	@Override
	public void update(Subject subject) {
		System.out.println("观察到主题状态为："  + subject.getSubjectStatus());
	}
}
