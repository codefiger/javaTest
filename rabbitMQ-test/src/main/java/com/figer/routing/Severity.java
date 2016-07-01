package com.figer.routing;

import java.util.Random;

/**
 * Created by figer on 7/1/16.
 */
public enum Severity {
  info,//0
  warm,//1
  error,//2
  ;

  public static Severity getRandomSevertiy(){
    Random random = new Random();
    int ordinal = random.nextInt(3);
    System.out.println("ordinal:" + ordinal);
    return Severity.class.getEnumConstants()[ordinal];
  }
}
