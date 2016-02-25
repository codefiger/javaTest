package com.figer.pattern.oberver;

public interface Oberver {
	void update();
	
	void update(Subject subject);
}
