package com.figer.event;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath*:mailbeans.xml"
})
public class SpringEventTest {
	@Autowired
	private MailSender mailSender;
	@Test
	public void testMailEvent(){
		mailSender.sendMail("home");
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("mailbeans.xml");
		MailSender sender = ctx.getBean("mailSender", MailSender.class);
		sender.sendMail(" home ");
	}
}
