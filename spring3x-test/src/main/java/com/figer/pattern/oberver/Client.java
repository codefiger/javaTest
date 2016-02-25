package com.figer.pattern.oberver;

public class Client {
	public static void main(String[] args) {
		pullObserverPattern();
	}
	
	/**
	 * 拉模型观察者
	 */
	private static void pullObserverPattern(){
		Oberver oberver = new ObserverImpl();
		Oberver oberver2 = new ObserverImpl();
		
		SubjectImpl subject = new SubjectImpl();
		subject.setSubjectStatus("started");
		subject.setOberver(oberver);
		subject.setOberver(oberver2);
		
		subject.pullChange();
	}
	
	/**
	 * 推模型观察者
	 */
	private static void pushObserverPattern(){
		Oberver oberver = new ObserverImpl();
		Oberver oberver2 = new ObserverImpl();
		
		SubjectImpl subject = new SubjectImpl();
		subject.setOberver(oberver);
		subject.setOberver(oberver2);
		
		subject.change();
	}
}
