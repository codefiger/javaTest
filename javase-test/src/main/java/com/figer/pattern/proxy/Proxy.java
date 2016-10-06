package com.figer.pattern.proxy;

/**
 * Created by figer on 10/6/16.
 */
public class Proxy implements Subject {
  private Subject subject;

  public Proxy(Subject subject) {
    this.subject = subject;
  }

  private void beforeRequest(){
    System.out.println("before request");
  }

  private void afterRequest(){
    System.out.println("before request");
  }

  @Override
  public void request() {
    beforeRequest();
    subject.request();
    afterRequest();
  }
}
