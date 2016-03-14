package com.figer.pattern.abstractFactory;

public class SmsSender implements Sender {

	@Override
	public void send() {
		System.out.println("sms sender");
	}

}
