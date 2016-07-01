package com.figer.topic.routing;

/**
 * Created by figer on 7/1/16.
 */
public class NormalRouteSubscriber {
  public static void main(String[] args) {
    try {
      new TopicSubscriberFactory().runDirectSubscriber(new String[]{"info.*", "warm.*"});
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
