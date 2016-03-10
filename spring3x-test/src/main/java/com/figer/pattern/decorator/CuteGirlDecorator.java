package com.figer.pattern.decorator;

public class CuteGirlDecorator extends GirlDecorator {

	public CuteGirlDecorator(Girl girl) {
		super(girl);
	}
	
	@Override
	public void sing() {
		System.out.println("she is a cute girl...");
		super.sing();
	}

}
