package com.figer.pattern.decorator;

public abstract class GirlDecorator extends Girl {
	
	private Girl girl;
	
	public GirlDecorator(Girl girl) {
		this.girl = girl;
	}

	@Override
	public void sing() {
		girl.sing();
	}

}
