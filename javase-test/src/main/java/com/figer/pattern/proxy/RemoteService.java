package com.figer.pattern.proxy;

/**
 * Created by figer on 10/6/16.
 */
public class RemoteService implements IRemoteService {
  @Override
  public void create() {
    beforeRequest();
    System.out.println("invoke the real create...");
    afterRequest();
  }

  private void beforeRequest(){
    System.out.println("before create");
  }

  private void afterRequest(){
    System.out.println("before create");
  }
}
