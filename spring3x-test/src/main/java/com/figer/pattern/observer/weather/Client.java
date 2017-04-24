package com.figer.pattern.observer.weather;

/**
 * Created by figer on 17/04/2017.
 */
public class Client {
  public static void main(String[] args) {
    Weather weather = new Weather();
    weather.addObserver(new Person());
    weather.addObserver(new Tree());

    weather.timePasses();
  }
}
