package com.figer.algorithm.algs4.sorting;

/**
 * Created by figer on 21/05/2017.
 */
public class Selection extends SortTemplate {
  @Override
  public void sort(Comparable[] array) {
    for (int i = 0; i < array.length - 1; i++) {
      int min = i;
      for (int j = i + 1; j < array.length; j++) {
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
