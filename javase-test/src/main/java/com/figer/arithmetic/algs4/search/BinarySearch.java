package com.figer.arithmetic.algs4.search;

import com.figer.arithmetic.algs4.utils.In;
import com.figer.arithmetic.algs4.utils.StdIn;
import com.figer.arithmetic.algs4.utils.StdOut;

import java.util.Arrays;

/**
 * Created by figer on 06/03/2017.
 */
public class BinarySearch {
  public static int rank(int key, int[] a){
    //a must be sorted
    int lowIndex = 0;
    int highIndex = a.length - 1;
    if(key < a[lowIndex] || key > a[highIndex]){
      return -1;
    }

    while (lowIndex <= highIndex){
      int middle = lowIndex + (highIndex - lowIndex)/2;
      if(key > a[middle]){
        lowIndex = middle + 1;
      }else if(key < a[middle]){
        highIndex = middle - 1;
      }else{
        return middle;
      }
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
    while (!StdIn.isEmpty()){
      int key = StdIn.readInt();
      if(rank(key, whiteList) == -1){
        StdOut.println(key);
      }
    }
    System.out.println("total use: " + (System.currentTimeMillis() - startTime) + " ms");
  }
}
