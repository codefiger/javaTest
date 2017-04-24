package com.figer.arithmetic.algs4.test;

/**
 * Created by figer on 05/04/2017.
 */
public class Person {
  private String name;

  public Person(String name) {
    this.name = name;
  }

  public static void replace(Person b){
    b = new Person("B");
  }

  public static void rename(Person c){
    c.name = "C";
  }

  public static void main(String[] args) {
    Person a = new Person("A");

    replace(a);

    rename(a);
  }

}
