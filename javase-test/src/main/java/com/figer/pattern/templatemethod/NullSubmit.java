package com.figer.pattern.templatemethod;

/**
 * Created by figer on 18/11/2016.
 */
public class NullSubmit extends SubmitAbsTemplate {
  @Override
  public void prepareData() {
    System.out.println("NullSubmit.prepareData");
  }

  @Override
  public void changeStatus() {
    System.out.println("NullSubmit.changeStatus");
  }

  @Override
  public void request() {
    System.out.println("NullSubmit.request");
  }
}
