package com.figer.spring.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by figer on 26/04/2017.
 */

@Component
public class MyComponent {
  @Value("${name}")
  private String name;

  @Value("${age}")
  private int age;

  @Value("${my.intList.property}")
  private List<Integer> intList;

  public String getName() {
    return name;
  }

  public MyComponent setName(String name) {
    this.name = name;
    return this;
  }

  public int getAge() {
    return age;
  }

  public MyComponent setAge(int age) {
    this.age = age;
    return this;
  }

  public List<Integer> getIntList() {
    return intList;
  }

  public MyComponent setIntList(List<Integer> intList) {
    this.intList = intList;
    return this;
  }
}
