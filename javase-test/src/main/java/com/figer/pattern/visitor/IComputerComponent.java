package com.figer.pattern.visitor;

/**
 * Created by figer on 19/11/2016.
 */
public interface IComputerComponent {
  void accept(IComputerComponentVisitor componentVisitor);
}
