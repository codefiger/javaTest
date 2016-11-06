package com.figer.pattern.memento;

/**
 * Created by figer on 06/11/2016.
 */
public class CareTaker {
  private Memento memento;

  public Memento getMemento() {
    return memento;
  }

  public CareTaker setMemento(Memento memento) {
    this.memento = memento;
    return this;
  }
}
