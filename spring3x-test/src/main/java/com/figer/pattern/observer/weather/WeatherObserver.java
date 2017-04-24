package com.figer.pattern.observer.weather;

/**
 * Created by figer on 17/04/2017.
 */
public interface WeatherObserver {
  void update(WeatherType currentWeather);
}
