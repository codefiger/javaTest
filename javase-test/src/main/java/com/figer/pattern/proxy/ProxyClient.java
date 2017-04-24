package com.figer.pattern.proxy;

/**
 * Created by figer on 10/6/16.
 */
public class ProxyClient {
  public static void main(String[] args) {
    IRemoteService subject = new RemoteServiceProxy(new RemoteService());
    subject.create();
  }
}
