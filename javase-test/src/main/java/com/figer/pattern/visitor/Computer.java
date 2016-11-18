package com.figer.pattern.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by figer on 19/11/2016.
 */
public class Computer implements IComputerComponent {
  private List<IComputerComponent> computerComponents = new ArrayList<IComputerComponent>();

  public Computer() {
    computerComponents.add(new Mouse());
    computerComponents.add(new Keyboard());
  }

  @Override
  public void accept(IComputerComponentVisitor componentVisitor) {
    for(IComputerComponent component : computerComponents){
      component.accept(componentVisitor);
    }

    componentVisitor.visit(this);
  }
}
