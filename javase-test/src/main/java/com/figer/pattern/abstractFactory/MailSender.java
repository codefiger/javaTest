package com.figer.pattern.abstractFactory;

public class MailSender implements Sender {

	@Override
	public void send() {
		System.out.println("mail sender");
	}

}
