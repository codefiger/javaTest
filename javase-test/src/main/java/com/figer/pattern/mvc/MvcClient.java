package com.figer.pattern.mvc;

/**
 * Created by figer on 19/11/2016.
 */
public class MvcClient {
  public static void main(String[] args) {
    Model model = new Model(111L, "figer");
    View view = new View();

    Controller controller = new Controller(model, view);
    controller.displayView();
  }
}
