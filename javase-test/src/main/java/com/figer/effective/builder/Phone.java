package com.figer.effective.builder;

/**
 * Created by figer on 9/26/16.
 */
public class Phone {
  private long id;
  private String type;
  private String color;
  private int size;
  private int height;
  private int width;
  private int length;

  public long getId(){
    return id;
  }

  private Phone(Builder builder){
    this.color = builder.color;
    this.height = builder.height;
    this.id = builder.id;
    this.length = builder.length;
    this.size = builder.size;
    this.type = builder.type;
    this.width = builder.width;
  }

  public static class Builder{
    private final long id;
    private String type;
    private String color;
    private int size;
    private int height;
    private int width;
    private int length;

    public Builder(long id){
      this.id = id;
    }

    public Phone build(){
      return new Phone(this);
    }

    public Builder setType(String type) {
      this.type = type;
      return this;
    }

    public Builder setColor(String color) {
      this.color = color;
      return this;
    }

    public Builder setSize(int size) {
      this.size = size;
      return this;
    }

    public Builder setHeight(int height) {
      this.height = height;
      return this;
    }

    public Builder setWidth(int width) {
      this.width = width;
      return this;
    }

    public Builder setLength(int length) {
      this.length = length;
      return this;
    }
  }

  @Override
  public boolean equals(Object obj) {
    return ((Phone)obj).getId() == id;
  }

  @Override
  public int hashCode() {
    return Long.valueOf(id).hashCode();
  }
}
