package com.figer.pattern.factoryMethod;

public class SendFactory {
	public static Sender getSender(String senderType){
		if("mail".equals(senderType)){
			return new MialSender();
		}else if("sms".equals(senderType)){
			return new SmsSender();
		}else 
			return null;
	}
}
