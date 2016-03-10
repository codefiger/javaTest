package com.figer.pattern.decorator;

public class Main {
	public static void main(String[] args) {
		Girl girl = new AmerianGirl();
		
		Girl chineseGirl = new ChineseGirl();
		
		Girl lovelyGirl = new LovelyGirlDecorator(girl);
		lovelyGirl.sing();
		
		lovelyGirl = new LovelyGirlDecorator(chineseGirl);
		lovelyGirl.sing();
	}
}
