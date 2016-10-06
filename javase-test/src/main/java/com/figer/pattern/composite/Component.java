package com.figer.pattern.composite;

import java.util.List;

/**
 * Created by figer on 10/6/16.
 */
public abstract class Component {
  public abstract void add(Component component);
  public abstract void remove(Component component);
  public abstract List<Component> getChildren();

  public abstract void handle();
}
