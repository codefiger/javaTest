package com.figer.pattern.abstractFactory;

/**
 * Created by figer on 10/10/2016.
 */
public class Client {
  public static void main(String[] args) {
    Provider provider = new MailSenderFactory();
    Sender sender = provider.getSender();
    sender.send();
  }
}
