package com.figer.algorithm.algs4.sorting;

/**
 * Created by figer on 11/06/2017.
 */
public class Quick extends SortTemplate {
  private static final int FACTOR = 15;
  private static final Insertion insertion = new Insertion();

  @Override
  public void sort(Comparable[] array, int low, int high) {
    sortInner(low, high, array);
  }

  private void sortInner(int low, int high, Comparable array[]){

    if(high <= low + FACTOR){
      insertion.sort(array, low, high);
      return;
    }else{
      int partitionIndex = partition(low, high, array);
      sortInner(low, partitionIndex - 1, array);
      sortInner(partitionIndex + 1, high, array);
    }
  }
}
