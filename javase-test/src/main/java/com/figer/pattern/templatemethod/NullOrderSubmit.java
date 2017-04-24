package com.figer.pattern.templatemethod;

/**
 * Created by figer on 18/11/2016.
 */
public class NullOrderSubmit extends OrderSubmitTemplate {
  @Override
  public void prepareData() {
    System.out.println("NullOrderSubmit.prepareData");
  }

  @Override
  public void changeStatus() {
    System.out.println("NullOrderSubmit.changeStatus");
  }

  @Override
  public void request() {
    System.out.println("NullOrderSubmit.create");
  }
}
