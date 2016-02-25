package com.figer.pattern.oberver.jdk;

import java.util.Observable;
import java.util.Observer;

public class Watcher implements Observer {
	public Watcher(Observable o) {
		o.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("观察到监视对象变化：" + ((Watched)o).getData());
	}

}
