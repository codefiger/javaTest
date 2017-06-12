package com.figer.algorithm.algs4.sorting;

/**
 * Created by figer on 21/05/2017.
 */
public class Selection extends SortTemplate {
  @Override
  public void sort(Comparable[] array, int low, int high) {
    for (int i = low; i <= high; i++) {
      int min = i;
      for (int j = i + 1; j <= high; j++) {
        if(less(array[j], array[min])){
          min = j;
        }
      }

      if(min != i){
        exch(array, i, min);
      }
    }
  }
}
