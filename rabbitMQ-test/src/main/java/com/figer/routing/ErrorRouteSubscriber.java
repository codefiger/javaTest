package com.figer.routing;

/**
 * Created by figer on 7/1/16.
 */
public class ErrorRouteSubscriber {
  public static void main(String[] args) {
    try {
      new DirectSubscriberFactory().runDirectSubscriber(new Severity[]{Severity.error});
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
