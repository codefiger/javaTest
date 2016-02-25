package com.figer.pattern.oberver;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
	private String subjectStatus;
	private List<Oberver> obervers = new ArrayList<>();

	public List<Oberver> getObervers() {
		return obervers;
	}

	public void setOberver(Oberver oberver) {
		this.obervers.add(oberver);
	}
	
	public String getSubjectStatus() {
		return subjectStatus;
	}

	public void setSubjectStatus(String subjectStatus) {
		this.subjectStatus = subjectStatus;
	}

	public void notifyObserver(){
		for (Oberver oberver : obervers) {
			oberver.update();
		}
	}
	
	public void notifyPullObserver(){
		for (Oberver oberver : obervers) {
			oberver.update(this);
		}
	}
}
