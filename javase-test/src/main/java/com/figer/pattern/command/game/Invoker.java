package com.figer.pattern.command.game;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by figer on 05/11/2016.
 */
public class Invoker {
  private Deque<Command> undoDeque = new LinkedList<Command>();
  private Deque<Command> redoDeque = new LinkedList<Command>();

  public void doCommand(Command command, Target target){
    undoDeque.offerLast(command);
    command.action(target);
    System.out.println(command.getClass().getName() + " doCommand");
    target.print();
  }

  public void undoCommand(Target target){
    Command command = undoDeque.pollLast();
    redoDeque.offerLast(command);
    command.undo(target);
    System.out.println(command.getClass().getName() + " undoCommand");
    target.print();
  }

  public void redoCommand(Target target){
    Command command = redoDeque.pollLast();
    undoDeque.offerLast(command);
    command.redo(target);
    System.out.println(command.getClass().getName() + " redoCommand");
    target.print();
  }
}
