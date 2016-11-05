package com.figer.pattern.command.game;

/**
 * Created by figer on 05/11/2016.
 */
public class Target {
  private int index;

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }

  public void print(){
    System.out.println("Target index is :" + index);
    System.out.println("====================================================================================");
  }
}
