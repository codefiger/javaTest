package com.figer;

/**
 * Created by figer on 26/05/2017.
 */
public class ContractAddInfo {
  int pageIndex;
  float x;
  float y;
  String content;
  String name;

  public int getPageIndex() {
    return pageIndex;
  }

  public ContractAddInfo setPageIndex(int pageIndex) {
    this.pageIndex = pageIndex;
    return this;
  }

  public float getX() {
    return x;
  }

  public ContractAddInfo setX(float x) {
    this.x = x;
    return this;
  }

  public float getY() {
    return y;
  }

  public ContractAddInfo setY(float y) {
    this.y = y;
    return this;
  }

  public String getContent() {
    return content;
  }

  public ContractAddInfo setContent(String content) {
    this.content = content;
    return this;
  }

  public String getName() {
    return name;
  }

  public ContractAddInfo setName(String name) {
    this.name = name;
    return this;
  }
}
