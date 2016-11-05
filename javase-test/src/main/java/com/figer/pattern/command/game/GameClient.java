package com.figer.pattern.command.game;

/**
 * Created by figer on 05/11/2016.
 */
public class GameClient {
  public static void main(String[] args) {
    Target target = new Target();
    target.print();
    Invoker invoker = new Invoker();
    Command addOne = new AddOneCommand();
    invoker.doCommand(addOne, target);
    invoker.doCommand(addOne, target);
    invoker.doCommand(addOne, target);
    invoker.undoCommand(target);
    invoker.redoCommand(target);

    invoker.undoCommand(target);
    invoker.undoCommand(target);
    Command addTwo = new AddTwoCommand();
    invoker.doCommand(addTwo, target);
    invoker.doCommand(addTwo, target);
    invoker.undoCommand(target);
    invoker.redoCommand(target);
  }
}
