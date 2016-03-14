package com.figer.pattern.abstractFactory;

public class SmsSenderFactory implements Provider {

	@Override
	public Sender getSender() {
		return new SmsSender();
	}

}
