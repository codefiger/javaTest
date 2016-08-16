package com.figer.entity;

/**
 * Created by figer on 8/15/16.
 */
public class Product {
  private Long id;
  private String name;

  public Product() {
    System.out.println("create a product,id = " + id + ",name = " + name);
  }

  public Product(Long id) {
    this.id = id;
  }

  public Product(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString(){
    return "product id:" + id + ",name:" + name;
  }
}
