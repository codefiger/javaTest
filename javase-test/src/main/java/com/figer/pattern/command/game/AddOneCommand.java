package com.figer.pattern.command.game;

/**
 * Created by figer on 05/11/2016.
 */
public class AddOneCommand implements Command {
  @Override
  public void action(Target target) {
    target.setIndex(target.getIndex() + 1);
  }

  @Override
  public void undo(Target target) {
    target.setIndex(target.getIndex() - 1);
  }

  @Override
  public void redo(Target target) {
    target.setIndex(target.getIndex() + 1);
  }
}
