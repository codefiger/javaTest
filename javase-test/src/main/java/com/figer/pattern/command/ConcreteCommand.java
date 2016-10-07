package com.figer.pattern.command;

/**
 * Created by figer on 07/10/2016.
 */
public class ConcreteCommand implements Command {
  private Receiver receiver = new Receiver();

  @Override
  public void execute() {
    receiver.action();
  }
}
