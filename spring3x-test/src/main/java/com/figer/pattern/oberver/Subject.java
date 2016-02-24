package com.figer.pattern.oberver;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
	private List<Oberver> obervers = new ArrayList<>();

	public List<Oberver> getObervers() {
		return obervers;
	}

	public void setOberver(Oberver oberver) {
		this.obervers.add(oberver);
	}
	
	public void notifyObserver(){
		for (Oberver oberver : obervers) {
			oberver.update();
		}
	}
}
