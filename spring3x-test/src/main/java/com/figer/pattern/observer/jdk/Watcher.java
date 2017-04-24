package com.figer.pattern.observer.jdk;

import java.util.Observable;
import java.util.Observer;

public class Watcher implements Observer {
  private String name;
	public Watcher(Observable o, String name) {
    this.name = name;
		o.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println(name + "观察到监视对象变化：" + ((Watched)o).getData());
	}

}
