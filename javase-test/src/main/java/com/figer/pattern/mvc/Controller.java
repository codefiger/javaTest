package com.figer.pattern.mvc;

/**
 * Created by figer on 19/11/2016.
 */
public class Controller {
  private Model model;
  private View view;

  public Controller(Model model, View view) {
    this.model = model;
    this.view = view;
  }

  public void displayView(){
    view.showView(model);
  }
}
