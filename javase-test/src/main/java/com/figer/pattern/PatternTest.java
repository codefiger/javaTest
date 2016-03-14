package com.figer.pattern;

import org.junit.Test;

import com.figer.pattern.abstractFactory.MailSenderFactory;
import com.figer.pattern.abstractFactory.Provider;
import com.figer.pattern.factoryMethod.SendFactory;

public class PatternTest {
	@Test
	public void methodFactoryTest(){
		SendFactory.getSender("mail").send();
	}
	
	@Test
	public void abstractFactoryTest(){
		Provider provider = new MailSenderFactory();
		provider.getSender().send();
	}
}
