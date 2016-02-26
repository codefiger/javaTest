package com.figer.domain;

import com.figer.annotation.Description;

public class SmartSeller implements Sellable {

	@Override
	@Description
	public void sell(String goods) {
		System.out.println("Sell " + goods);
	}

}
