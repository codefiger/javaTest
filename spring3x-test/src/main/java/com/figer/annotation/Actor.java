package com.figer.annotation;

import java.math.BigDecimal;

/**
 * Created by figer on 30/06/2017.
 */
public class Actor {

  private int age;
  private String name;
  private BigDecimal amount;

  @BindField("age")
  public int getAge() {
    return age;
  }

  public Actor setAge(int age) {
    this.age = age;
    return this;
  }

  @BindField("name")
  public String getName() {
    return name;
  }

  public Actor setName(String name) {
    this.name = name;
    return this;
  }

  @BindField("amount")
  public BigDecimal getAmount() {
    return amount;
  }

  public Actor setAmount(BigDecimal amount) {
    this.amount = amount;
    return this;
  }
}
