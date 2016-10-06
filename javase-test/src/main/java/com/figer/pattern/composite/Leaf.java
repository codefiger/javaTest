package com.figer.pattern.composite;

import java.util.List;

/**
 * Created by figer on 10/6/16.
 */
public class Leaf extends Component {
  @Override
  public void add(Component component) {
    throw new UnsupportedOperationException("Leaf not support that!");
  }

  @Override
  public void remove(Component component) {
    throw new UnsupportedOperationException("Leaf not support that!");
  }

  @Override
  public List<Component> getChildren() {
    throw new UnsupportedOperationException("Leaf not support that!");
  }

  @Override
  public void handle() {
    System.out.println("handle leaf ...");
  }
}
