package com.figer.topic.routing;

/**
 * Created by figer on 7/1/16.
 */
public class CronRouteSubscriber {
  public static void main(String[] args) {
    try {
      new TopicSubscriberFactory().runDirectSubscriber(new String[]{"*.cron"});
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
