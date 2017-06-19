package com.figer.algorithm.algs4.sorting.priorityqueue;

/**
 * Created by figer on 15/06/2017.
 */
public class HeapMaxPQ<Key extends Comparable<Key>> extends MaxPQ<Key>{
  private Key pq[];

  public HeapMaxPQ(int max) {
    this.max = max;
    pq = (Key[]) new Comparable[max + 1];
  }

  @Override
  protected void pureInsert(Key key) {
    if(size < max){
      pq[++size] = key;
      swim(size);
    }else if(pq[size].compareTo(key) < 0){
      if(less(size, size - 1)){
        pq[size] = key;
        swim(size);
      }else{
        pq[size-1] = key;
        swim(size - 1);
      }
    }
  }

  @Override
  protected Key pureDelMax() {
    Key max = pq[1];
    exch(1, size--);
    sink(1);
    return max;
  }

  @Override
  protected Key max() {
    return pq[1];
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
    while(2*k <= size){
      int i = 2*k;
      if(i < size && less(i, i + 1)){
        i++;
      }
      if(!less(k, i)){
        break;
      }else {
        exch(i, k);
        k = i;
      }
    }
  }


}
