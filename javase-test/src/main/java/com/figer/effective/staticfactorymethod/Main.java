package com.figer.effective.staticfactorymethod;

import java.util.Date;

/**
 * Created by figer on 9/26/16.
 */
public class Main {
  public static void main(String[] args) {
    Services.registerProvider(new Provider() {
      @Override
      public Service newService() {
        return new Service() {
          @Override
          public void introduceSelf() {
            System.out.println(String.format("my name is figer(%s)", new Date()));
          }
        };
      }
    });

    Services.newInstance().introduceSelf();

  }
}
