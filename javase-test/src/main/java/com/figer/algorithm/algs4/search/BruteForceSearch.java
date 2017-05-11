package com.figer.algorithm.algs4.search;

/**
 * Created by figer on 17/03/2017.
 */
public class BruteForceSearch {
  public static int rank(int key, int[] a){
    //a must be sorted
    for (int i = 0; i < a.length; i++) {
     if(key == a[i]){
       return i;
     }
    }
    return -1;
  }
}
