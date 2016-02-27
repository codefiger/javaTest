package com.figer.domain;

import com.figer.annotation.Description;

public class SmartSeller implements Sellable {

	@Override
	@Description
	public void sell(String goods) {
		System.out.println("Sell " + goods);
	}
	
	private void privateMethod(){
		System.out.println("I'm a private method");
	}
	
	public void eatLunch(){
		System.out.println("I'm a eatLunch method");
	}

}
