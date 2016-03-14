package com.figer.pattern.abstractFactory;

public class MailSenderFactory implements Provider {

	@Override
	public Sender getSender() {
		return new MailSender();
	}

}
