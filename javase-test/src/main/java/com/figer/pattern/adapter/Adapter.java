package com.figer.pattern.adapter;

/**
 * Created by figer on 10/6/16.
 */
public class Adapter implements Target {

  private Adaptee adaptee;
  private AdapteeB adapteeB;
  private AdapteeC adapteeC;

  public Adapter() {
    adaptee = new Adaptee();
    adapteeB = new AdapteeB();
    adapteeC = new AdapteeC();
  }

  @Override
  public void request() {
    this.adaptee.realRequestHandler();
  }

  @Override
  public void requestB() {
    this.adapteeB.realRequestHandler();
  }

  @Override
  public void requestC() {
    this.adapteeC.realRequestHandler();
  }
}
