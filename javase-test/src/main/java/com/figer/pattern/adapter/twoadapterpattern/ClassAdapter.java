package com.figer.pattern.adapter.twoadapterpattern;

/**
 * Created by figer on 02/11/2016.
 * 我是两头三头插头转换器
 */
public class ClassAdapter extends PlayerAdaptee implements Target {
  @Override
  public void sing() {
    System.out.println("ClassAdapter:sing..");
  }
}
