package com.figer.pattern.decorator;

/**
 * Created by figer on 10/6/16.
 */
public class DecoratorClient {
  public static void main(String[] args) {
    Component textBox = new TextBox();
    Component scrollTextBox = new ScrollBorderDecorator(textBox);
    scrollTextBox.display();

    System.out.println("------");
    Component listBox = new TextBox();
    Component blackListBox = new BlackBorderDecorator(listBox);
    blackListBox.display();
  }
}
