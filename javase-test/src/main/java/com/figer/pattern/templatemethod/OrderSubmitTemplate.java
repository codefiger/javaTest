package com.figer.pattern.templatemethod;

/**
 * Created by figer on 18/11/2016.
 */
public abstract class OrderSubmitTemplate {
  protected abstract void prepareData();
  protected abstract void changeStatus();
  protected abstract void request();

  public final void submit(){
    System.out.println("submit begin:");
    this.prepareData();
    this.changeStatus();
    this.request();
    System.out.println("submit success!");
  }
}
