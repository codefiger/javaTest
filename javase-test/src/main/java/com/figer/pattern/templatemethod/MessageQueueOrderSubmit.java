package com.figer.pattern.templatemethod;

/**
 * Created by figer on 18/11/2016.
 */
public class MessageQueueOrderSubmit extends OrderSubmitTemplate {
  @Override
  public void prepareData() {
    System.out.println("MessageQueueOrderSubmit.prepareData");
  }

  @Override
  public void changeStatus() {
    System.out.println("MessageQueueOrderSubmit.changeStatus");
  }

  @Override
  public void request() {
    System.out.println("MessageQueueOrderSubmit.request");
  }
}
