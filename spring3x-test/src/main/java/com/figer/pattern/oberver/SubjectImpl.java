package com.figer.pattern.oberver;

public class SubjectImpl extends Subject {

	public void change() {
		System.out.println("变化");
		super.notifyObserver();
	}
	
	public void pullChange() {
		setSubjectStatus("stop");
		System.out.println("变化");
		notifyPullObserver();
	}
}
