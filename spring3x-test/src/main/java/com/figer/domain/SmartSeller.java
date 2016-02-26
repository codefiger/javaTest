package com.figer.domain;

public class SmartSeller implements Sellable {

	@Override
	public void sell(String goods) {
		System.out.println("Sell " + goods);
	}

}
