package com.figer.pattern.visitor;

/**
 * Created by figer on 19/11/2016.
 */
public class Mouse implements IComputerComponent {

  @Override
  public void accept(IComputerComponentVisitor componentVisitor) {
    componentVisitor.visit(this);
  }
}
