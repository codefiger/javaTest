package com.figer.pattern.memento;

/**
 * Created by figer on 06/11/2016.
 */
public class MementoClient {
  public static void main(String[] args) {
    Order order = new Order();
    order.printOrder();
    CareTaker careTaker = new CareTaker().setMemento(order.createMemento());

    order.transformStatus();
    order.printOrder();
    order.transformStatus();
    order.printOrder();

    order.setStatus(careTaker.getMemento().getStatus());
    order.printOrder();
  }
}
