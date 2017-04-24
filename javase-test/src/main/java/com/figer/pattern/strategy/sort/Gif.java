package com.figer.pattern.strategy.sort;

/**
 * Created by figer on 21/04/2017.
 */
public class Gif implements Comparable<Gif>{
  int length;
  int width;

  public Gif(int length, int width) {
    this.length = length;
    this.width = width;
  }

  @Override
  public int compareTo(Gif o) {
    if(this.length > o.length){ return 1; }
    else if(this.length < o.length){ return -1; }
    return 0;
  }

  @Override
  public String toString() {
    return "Gif{" +
        "length=" + length +
        ", width=" + width +
        '}';
  }
}
