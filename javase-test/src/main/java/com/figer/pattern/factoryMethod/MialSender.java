package com.figer.pattern.factoryMethod;

public class MialSender implements Sender {

	@Override
	public void send() {
		System.out.println("mail sender");
	}

}
