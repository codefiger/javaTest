package com.figer.pattern.command.game;

/**
 * Created by figer on 05/11/2016.
 */
public interface Command {
  void action(Target target);
  void undo(Target target);
  void redo(Target target);
}
