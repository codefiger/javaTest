package com.figer.pattern.decorator;

public class LovelyGirlDecorator extends GirlDecorator {

	public LovelyGirlDecorator(Girl girl) {
		super(girl);
	}
	
	@Override
	public void sing() {
		System.out.println("she is a lovely girl...");
		super.sing();
	}

}
