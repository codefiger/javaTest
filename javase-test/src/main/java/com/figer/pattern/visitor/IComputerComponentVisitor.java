package com.figer.pattern.visitor;

/**
 * Created by figer on 19/11/2016.
 */
public interface IComputerComponentVisitor {
  void visit(Computer computer);
  void visit(Mouse mouse);
  void visit(Keyboard keyboard);
}
