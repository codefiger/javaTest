package com.figer.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

public class MailSendEvent extends ApplicationContextEvent {
	private static final long serialVersionUID = -9196308442315006561L;
	
	private String to;

	public MailSendEvent(ApplicationContext source, String to) {
		super(source);
		this.to = to;
	}

	public String getTo(){
		return to;
	}
}
