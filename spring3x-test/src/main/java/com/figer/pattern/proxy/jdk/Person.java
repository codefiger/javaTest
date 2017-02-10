package com.figer.pattern.proxy.jdk;

public class Person {
	public void eat(String foodName){
		System.out.println("eat " + foodName);
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

    smile();
	}

  public void smile(){
    try {
      Thread.sleep(2500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("-----smile----:)");
  }
}
