package com.figer.serialization;

import java.io.Serializable;

/**
 * Created by figer on 10/04/2017.
 */
public class Person implements Serializable{
  private static final long serialVersionUID = 1L;

  private int age;
  private String name;
 /* private String extra;

  public String getExtra() {
    return extra;
  }

  public Person setExtra(String extra) {
    this.extra = extra;
    return this;
  }*/

  public Person() {}

  public Person(int age, String name) {
    this.age = age;
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
