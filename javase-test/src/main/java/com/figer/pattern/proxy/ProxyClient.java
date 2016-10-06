package com.figer.pattern.proxy;

/**
 * Created by figer on 10/6/16.
 */
public class ProxyClient {
  public static void main(String[] args) {
    Subject subject = new Proxy(new RealSubject());
    subject.request();
  }
}
