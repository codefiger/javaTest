package com.figer.domain;

import com.figer.annotation.Description;

public class MaleSmartSeller extends SmartSeller {
	@Description
	public void seduceGirl(){
		System.out.println("he is seducing a female customer!");
	}
}
