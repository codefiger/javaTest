package com.figer.pattern.decorator;

/**
 * Created by figer on 10/6/16.
 */
public class BlackBorderDecorator extends DecoratorComponent {
  public BlackBorderDecorator(Component component) {
    super(component);
  }

  @Override
  public void display() {
    this.blackBorder();
    super.display();
  }

  public void blackBorder(){
    System.out.println("now border is black");
  }
}
