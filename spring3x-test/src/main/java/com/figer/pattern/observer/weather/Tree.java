package com.figer.pattern.observer.weather;

/**
 * Created by figer on 17/04/2017.
 */
public class Tree implements WeatherObserver {
  @Override
  public void update(WeatherType currentWeather) {
    System.out.println(currentWeather.name());
  }
}
