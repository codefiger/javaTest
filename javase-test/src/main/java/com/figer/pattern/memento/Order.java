package com.figer.pattern.memento;

/**
 * Created by figer on 06/11/2016.
 */
public class Order {
  private Status status;

  public Status getStatus() {
    return status;
  }

  public void transformStatus() {
    if(status == null){
      status = Status.CREATED;
      return;
    }

    this.status = Status.values()[(status.ordinal() + 1) % Status.values().length];
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public void printOrder(){
    System.out.println("Order status: " + status);
  }

  public Memento createMemento(){
    return new Memento(status);
  }

}
