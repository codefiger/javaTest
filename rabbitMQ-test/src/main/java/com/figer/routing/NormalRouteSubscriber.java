package com.figer.routing;

/**
 * Created by figer on 7/1/16.
 */
public class NormalRouteSubscriber {
  public static void main(String[] args) {
    try {
      new DirectSubscriberFactory().runDirectSubscriber(new Severity[]{Severity.warm, Severity.info});
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
