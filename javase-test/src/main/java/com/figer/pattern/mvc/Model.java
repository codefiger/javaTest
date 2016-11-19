package com.figer.pattern.mvc;

/**
 * Created by figer on 19/11/2016.
 */
public class Model {
  private Long id;
  private String name;

  public Model(Long id, String name) {
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
  public String toString() {
    return "Model{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}
