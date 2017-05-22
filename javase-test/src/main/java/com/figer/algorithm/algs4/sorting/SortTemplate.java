package com.figer.algorithm.algs4.sorting;

/**
 * Created by figer on 21/05/2017.
 */
public abstract class SortTemplate {
  public abstract void sort(Comparable array[]);

  public boolean less(Comparable a, Comparable b){
    return a.compareTo(b) < 0;
  }

  public void exch(Comparable array[], int i, int j){
    Comparable temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  public void show(Comparable array[]){
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + " ");
    }
    System.out.println();
  }
  
  public boolean isSorted(Comparable array[]){
    for (int i = 1; i < array.length; i++) {
      if(less(array[i], array[i-1])){
        return false;
      }
    }
    return true;
  }
}
