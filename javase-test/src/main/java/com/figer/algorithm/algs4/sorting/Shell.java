package com.figer.algorithm.algs4.sorting;

/**
 * Created by figer on 01/06/2017.
 */
public class Shell extends SortTemplate{

  @Override
  public void sort(Comparable[] array) {
    final int factor = 2;
    for (int gap = array.length/factor; gap > 0; gap /= factor) {
      for (int i = gap; i < array.length; i++) {
        for (int j = i; j >= gap && less(array[j] , array[j - gap]); j -= gap) {
          exch(array, j, j - gap);
        }
      }
    }
  }
}
