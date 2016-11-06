package com.figer.pattern.memento;

/**
 * Created by figer on 06/11/2016.
 */
public class Memento {
  private Status status;

  public Memento(Status status) {
    this.status = status;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }
}
