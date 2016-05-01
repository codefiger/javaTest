package com.figer.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MailSender implements ApplicationContextAware {
	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	public void sendMail(String to){
		System.out.println("MailSender:发送邮件...");
		MailSendEvent mailSendEvent = new MailSendEvent(applicationContext, to);
		applicationContext.publishEvent(mailSendEvent);
	}

	public static void main(String[] args) {
		System.out.println(222);
	}

}
