package com.figer.pattern.proxy;

/**
 * Created by figer on 10/6/16.
 */
public class RemoteServiceProxy implements IRemoteService {
  private IRemoteService subject;

  public RemoteServiceProxy(IRemoteService subject) {
    this.subject = subject;
  }

  private void beforeRequest(){
    System.out.println("before create");
  }

  private void afterRequest(){
    System.out.println("before create");
  }

  @Override
  public void create() {
    beforeRequest();
    subject.create();
    afterRequest();
  }
}
