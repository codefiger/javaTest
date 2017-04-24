package com.figer.pattern.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
	private String subjectStatus;
	private List<Observer> observers = new ArrayList<Observer>();

	public void addObserver(Observer observer) {
		this.observers.add(observer);
	}
	
	public String getSubjectStatus() {
		return subjectStatus;
	}

	public void setSubjectStatus(String subjectStatus) {
		this.subjectStatus = subjectStatus;
	}

	public void notifyObserver(){
		for (Observer oberver : observers) {
			oberver.update();
		}
	}
	
	public void notifyPullObserver(){
		for (Observer oberver : observers) {
			oberver.update(this);
		}
	}
}
