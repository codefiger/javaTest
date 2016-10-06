package com.figer.pattern.decorator;

/**
 * Created by figer on 10/6/16.
 */
public class ScrollBorderDecorator extends DecoratorComponent {
  public ScrollBorderDecorator(Component component) {
    super(component);
  }

  @Override
  public void display() {
    this.scrollBorder();
    super.display();
  }

  public void scrollBorder(){
    System.out.println("now border can scroll");
  }
}
