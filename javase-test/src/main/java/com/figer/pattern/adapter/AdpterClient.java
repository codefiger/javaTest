package com.figer.pattern.adapter;

/**
 * Created by figer on 10/6/16.
 */
public class AdpterClient {
  public static void main(String[] args) {
    Target target = new Adapter();
    target.request();
  }
}
