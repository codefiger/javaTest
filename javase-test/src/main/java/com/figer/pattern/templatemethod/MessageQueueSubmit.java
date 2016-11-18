package com.figer.pattern.templatemethod;

/**
 * Created by figer on 18/11/2016.
 */
public class MessageQueueSubmit extends SubmitAbsTemplate {
  @Override
  public void prepareData() {
    System.out.println("MessageQueueSubmit.prepareData");
  }

  @Override
  public void changeStatus() {
    System.out.println("MessageQueueSubmit.changeStatus");
  }

  @Override
  public void request() {
    System.out.println("MessageQueueSubmit.request");
  }
}
