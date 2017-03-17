package com.figer.arithmetic.algs4.search;

import com.figer.arithmetic.algs4.utils.In;
import com.figer.arithmetic.algs4.utils.StdIn;

import java.util.Arrays;

/**
 * Created by figer on 06/03/2017.
 */
public class BinarySearch {
  public static int rank(int key, int[] a){
    //a must be sorted
    int lo = 0;
    int hi = a.length - 1;
    while (lo <= hi) {
      // Key is in a[lo..hi] or not present.
      int mid = lo + (hi - lo) / 2;
      if      (key < a[mid]) hi = mid - 1;
      else if (key > a[mid]) lo = mid + 1;
      else return mid;
    }
    return -1;
  }

  public static void main(String args[]){
    In in = new In(args[0]);
    int[] whiteList = in.readAllInts();
    Arrays.sort(whiteList);
    System.out.println(Arrays.toString(whiteList));
    StdIn.resyncSystemInByFile(args[1]);
    long startTime = System.currentTimeMillis();
    int count = 0;
    while (!StdIn.isEmpty()){
      int key = StdIn.readInt();
      if(rank(key, whiteList) == -1){
        //StdOut.println(key);
        count ++;
      }
    }
    System.out.println("binary search total use: " + (System.currentTimeMillis() - startTime) + " ms, count: " + count);

    StdIn.resyncSystemInByFile(args[1]);
    long bruteStartTime = System.currentTimeMillis();
    count = 0;
    while (!StdIn.isEmpty()){
      int key = StdIn.readInt();
      if(BruteForceSearch.rank(key, whiteList) == -1){
        //StdOut.println(key);
        count ++;
      }
    }
    System.out.println("brute search total use: " + (System.currentTimeMillis() - bruteStartTime) + " ms, count:" + count);

  }
}
