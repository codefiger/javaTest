package com.figer.algorithm.algs4.sorting.priorityqueue;

/**
 * Created by figer on 15/06/2017.
 */
public class HeapMaxPQ<Key extends Comparable<Key>> {
  private Key pq[];
  private int N;

  public HeapMaxPQ(int max) {
    N = max;
    pq = (Key[]) new Comparable[max + 1];
  }

  private boolean less(int i, int j){
    return pq[i].compareTo(pq[j]) < 0;
  }

  private void exch(int i, int j){
    Key temp = pq[i];
    pq[i] = pq[j];
    pq[j] = temp;
  }

  private void swim(int k){
    while (k > 1 && less(k/2, k)){
      exch(k/2, k);
      k = k/2;
    }
  }

  private void sink(int k){
    while(2*k <= N){
      int i = 2*k;
      if(i < N && less(i, i + 1)){
        i++;
      }
      if(less(i, k)){
        break;
      }else {
        exch(i, k);
        k = i;
      }
    }
  }

}
