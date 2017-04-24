package com.figer.pattern.observer.weather;

/**
 * Created by figer on 17/04/2017.
 */
public class Person implements WeatherObserver {
  @Override
  public void update(WeatherType currentWeather) {
    switch (currentWeather) {
      case COLD:
        System.out.println(String.format("Person : Cold."));
        break;
      case RAINY:
        System.out.println(String.format("Person : Rainy."));
        break;
      case SUNNY:
        System.out.println(String.format("Person : Sunny."));
        break;
      case WINDY:
        System.out.println(String.format("Person : Windy."));
        break;
      default:
        break;
    }
  }
}
