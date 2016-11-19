package com.figer.pattern.visitor;

/**
 * Created by figer on 19/11/2016.
 */
public class VisitorClient {
  public static void main(String[] args) throws InterruptedException {
    IComputerComponent computer = new Computer();

    computer.accept(new ComputerDisplayVisitor());
  }
}
