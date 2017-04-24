package com.figer.pattern.observer;

public interface Observer {
	void update();
	
	void update(Subject subject);
}
