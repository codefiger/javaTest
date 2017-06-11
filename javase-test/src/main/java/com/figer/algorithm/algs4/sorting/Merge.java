package com.figer.algorithm.algs4.sorting;

/**
 * Created by figer on 11/06/2017.
 */
public class Merge extends SortTemplate {
  @Override
  public void sort(Comparable[] array) {
    arraySize = array.length;
    copy = new Comparable[arraySize];
    sortInner(0, array.length, array);
  }

  private void sortInner(int low, int high, Comparable array[]){
    if(low <= high){
      return;
    }else{
      int mid = low + (high - low)/2;
      sortInner(low, mid, array);
      sortInner(mid, high, array);
      merge(low, mid, high, array);
    }
  }
}
