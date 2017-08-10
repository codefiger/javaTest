package com.figer.reliable.producer;

/**
 * Created by figer on 24/07/2017.
 */
public class Msg {
  private String id;
  private String name;
  private double score;

  public Msg(String id, String name, double score) {
    this.id = id;
    this.name = name;
    this.score = score;
  }

  public String getId() {
    return id;
  }

  public Msg setId(String id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public Msg setName(String name) {
    this.name = name;
    return this;
  }

  public double getScore() {
    return score;
  }

  public Msg setScore(double score) {
    this.score = score;
    return this;
  }
}
