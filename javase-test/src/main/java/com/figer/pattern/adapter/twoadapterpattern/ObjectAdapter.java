package com.figer.pattern.adapter.twoadapterpattern;

/**
 * Created by figer on 02/11/2016.
 */
public class ObjectAdapter implements Target {
  private PlayerAdaptee playerAdaptee;

  public ObjectAdapter(PlayerAdaptee playerAdaptee) {
    this.playerAdaptee = playerAdaptee;
  }

  @Override
  public void play() {
    this.playerAdaptee.play();
  }

  @Override
  public void sing() {
    System.out.println("ObjectAdapter:sing...");
  }
}
