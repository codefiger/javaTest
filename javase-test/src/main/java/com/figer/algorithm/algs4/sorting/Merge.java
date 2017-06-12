package com.figer.algorithm.algs4.sorting;

/**
 * Created by figer on 11/06/2017.
 */
public class Merge extends SortTemplate {
  public Merge() {
  }

  @Override
  public void sort(Comparable[] array, int low, int high) {
    if(copy == null){
      copy = new Comparable[array.length];
    }
    sortInner(low, high, array);
  }

  private void sortInner(int low, int high, Comparable array[]){
    if(high <= low){
      return;
    }else{
      int mid = low + (high - low)/2;
      sortInner(low, mid, array);
      sortInner(mid+1, high, array);
      merge(low, mid, high, array);
    }
  }
}
