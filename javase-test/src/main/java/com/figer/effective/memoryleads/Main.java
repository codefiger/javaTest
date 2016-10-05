package com.figer.effective.memoryleads;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by figer on 9/29/16.
 */
public class Main {
  private static final int LENGTH = 100000;

  public static void main(String[] args) {
    List<String> strList = new ArrayList<String>();

    for (int i = 0;i < LENGTH;i++){
      strList.add("line-" + i);
    }


    long startTime = System.currentTimeMillis();
    for (int i = 0; i < LENGTH; i++) {
      strList.get(i);
    }

    long secondTime = System.currentTimeMillis();
    System.out.println(secondTime - startTime);
    Iterator<String> strCar = strList.iterator();
    while (strCar.hasNext()) {
      strCar.next();
      strCar.remove();
    }

    long lastTime = System.currentTimeMillis();
    System.out.println(lastTime - secondTime);

  }
}
