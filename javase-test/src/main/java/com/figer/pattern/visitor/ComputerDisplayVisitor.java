package com.figer.pattern.visitor;

/**
 * Created by figer on 19/11/2016.
 */
public class ComputerDisplayVisitor implements IComputerComponentVisitor {
  @Override
  public void visit(Computer computer) {
    System.out.println("Displaying computer");
  }

  @Override
  public void visit(Mouse mouse) {
    System.out.println("Displaying mouse");
  }

  @Override
  public void visit(Keyboard keyboard) {
    System.out.println("Displaying keyboard");
  }
}
