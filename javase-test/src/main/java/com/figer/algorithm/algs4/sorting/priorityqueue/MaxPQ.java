package com.figer.algorithm.algs4.sorting.priorityqueue;

/**
 * Created by figer on 12/06/2017.
 */
public abstract class MaxPQ <Key extends Comparable>{
  protected int size = 0;
  protected int max;

  public MaxPQ(){}

  public MaxPQ(int max){
    this.max = max;
  }

  public void insert(Key key){
    pureInsert(key);
  }

  protected abstract void pureInsert(Key key);
  protected abstract Key pureDelMax();
  protected abstract Key max();

  public Key delMax(){
    Key delKey = pureDelMax();
    return delKey;
  }

  public boolean isEmpty(){
    return size == 0;
  }

  public int size(){
    return size;
  }
}
