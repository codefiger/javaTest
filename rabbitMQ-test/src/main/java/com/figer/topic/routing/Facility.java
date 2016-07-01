package com.figer.topic.routing;

import java.util.Random;

/**
 * Created by figer on 7/1/16.
 */
public enum Facility {
  auth,//0
  cron,//1
  calculate,//2
  ;

  public static Facility getRandomFacility(){
    Random random = new Random();
    int ordinal = random.nextInt(Facility.values().length);
    return Facility.class.getEnumConstants()[ordinal];
  }
}
