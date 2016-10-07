package com.figer.pattern.command;

/**
 * Created by figer on 07/10/2016.
 */
public class Invoker {
  private Command command;

  public Invoker(Command command) {
    this.command = command;
  }

  public void request(){
    command.execute();
  }
}
