package com.figer.pattern.observer;

public class Client {
	public static void main(String[] args) {
		pullObserverPattern();
	}
	
	/**
	 * 拉模型观察者
	 */
	private static void pullObserverPattern(){
		Observer oberver = new ObserverImpl();
		Observer oberver2 = new ObserverImpl();
		
		SubjectImpl subject = new SubjectImpl();
		subject.setSubjectStatus("started");
		subject.addObserver(oberver);
		subject.addObserver(oberver2);
		
		subject.pullChange();
	}
	
	/**
	 * 推模型观察者
	 */
	private static void pushObserverPattern(){
		Observer oberver = new ObserverImpl();
		Observer oberver2 = new ObserverImpl();
		
		SubjectImpl subject = new SubjectImpl();
		subject.addObserver(oberver);
		subject.addObserver(oberver2);
		
		subject.change();
	}
}
