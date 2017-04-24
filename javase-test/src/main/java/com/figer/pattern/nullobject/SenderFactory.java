package com.figer.pattern.nullobject;

/**
 * Created by figer on 18/11/2016.
 */
public class SenderFactory {

  public enum OrderType{
    purchase
  }

  public Sender getSender(OrderType orderType){
    if(orderType == OrderType.purchase){
      return new MailSender();
    }else{
      return new NullOrderService();
    }
  }
}
