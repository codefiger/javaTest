package com.figer.json;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * Created by figer on 05/05/2017.
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "name", scope = SingleDog.class)
public class SingleDog {
  private String name;
  private int age;
  private SingleDog partner;

  public SingleDog getPartner() {
    return partner;
  }

  public SingleDog setPartner(SingleDog partner) {
    this.partner = partner;
    return this;
  }

  public String getName() {
    return name;
  }

  public SingleDog setName(String name) {
    this.name = name;
    return this;
  }

  public int getAge() {
    return age;
  }

  public SingleDog setAge(int age) {
    this.age = age;
    return this;
  }
}
