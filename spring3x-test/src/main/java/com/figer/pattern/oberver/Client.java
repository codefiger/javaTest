package com.figer.pattern.oberver;

public class Client {
	public static void main(String[] args) {
		Oberver oberver = new ObserverImpl();
		Oberver oberver2 = new ObserverImpl();
		
		SubjectImpl subject = new SubjectImpl();
		subject.setOberver(oberver);
		subject.setOberver(oberver2);
		
		subject.change();
	}
}
