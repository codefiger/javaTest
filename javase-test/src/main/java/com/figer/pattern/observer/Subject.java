package com.figer.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by figer on 07/10/2016.
 */
public abstract class Subject {
  protected List<Observer> observers = new ArrayList<Observer>();

  public void add(Observer observer){
    observers.add(observer);
  }

  public void remove(Observer observer){
    observers.remove(observer);
  }

  public abstract void notifyObserver(Observer observer);
}
