package com.figer.pattern.decorator;

/**
 * Created by figer on 10/6/16.
 */
public abstract class DecoratorComponent extends Component {
  private Component component;

  public DecoratorComponent(Component component) {
    this.component = component;
  }

  @Override
  public void display() {
    component.display();
  }
}
