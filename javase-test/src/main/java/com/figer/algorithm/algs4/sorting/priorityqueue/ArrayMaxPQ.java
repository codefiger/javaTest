package com.figer.algorithm.algs4.sorting.priorityqueue;

/**
 * Created by figer on 13/06/2017.
 */
public class ArrayMaxPQ<Key extends Comparable> extends MaxPQ<Key> {
  private Comparable container[];

  public ArrayMaxPQ(int max) {
    super(max);
    container = new Comparable[max];
  }

  @Override
  public void pureInsert(Key key) {
    if(size >= max){
      int minIndex = findMin();
      if(key.compareTo(container[minIndex]) > 0){
        container[minIndex] = key;
      }
    }else {
      container[size++] = key;
    }
  }

  @Override
  public Key pureDelMax() {
    int maxIndex = findMax();
    Key max = (Key) container[maxIndex];
    if(maxIndex != size - 1){
      container[maxIndex] = container[size - 1];
    }
    container[--size] = null;
    return max;
  }

  @Override
  public Key max() {
    return (Key) container[findMax()];
  }

  private int findMin(){
    int minIndex = 0;
    for (int i = 1; i < size; i++) {
      if(container[minIndex].compareTo(container[i]) > 0){
        minIndex = i;
      }
    }
    return minIndex;
  }

  private int findMax(){
    int maxIndex = 0;
    for (int i = 1; i < size; i++) {
      if(container[maxIndex].compareTo(container[i]) < 0){
        maxIndex = i;
      }
    }
    return maxIndex;
  }
}
