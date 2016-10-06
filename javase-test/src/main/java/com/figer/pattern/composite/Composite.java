package com.figer.pattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by figer on 10/6/16.
 */
public class Composite extends Component {
  private List<Component> childrenComponent = new ArrayList<Component>();


  @Override
  public void add(Component component) {
    System.out.println("add component success!");
    childrenComponent.add(component);
  }

  @Override
  public void remove(Component component) {
    System.out.println("remove component success!");
    childrenComponent.remove(component);
  }

  @Override
  public List<Component> getChildren() {
    return childrenComponent;
  }

  @Override
  public void handle() {
    System.out.println("handle composite...");
    for (Component component : childrenComponent){
      component.handle();
    }
  }
}
