package com.figer.algorithm.algs4.sorting.priorityqueue;

import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by figer on 15/06/2017.
 */
public class SortedArrayMaxPQ<Key extends Comparable> extends MaxPQ<Key> {
  private List<Key> container;

  public SortedArrayMaxPQ(int max) {
    super(max);
    this.container = new ArrayList<>(max);
  }

  @Override
  protected void pureInsert(Key key) {
    container.add(key);
    for (int i = size; i >= 1 && container.get(i).compareTo(container.get(i-1)) > 0; i--) {
        Key temp = container.get(i - 1);
        container.set(i - 1, container.get(i));
        container.set(i, temp);
    }

    if(size < max){
      size ++;
    }
  }

  @Override
  protected Key pureDelMax() {
    Preconditions.checkArgument(size > 0);
    Key max = container.get(0);
    for (int i = 1; i < size; i++) {
      container.set(i - 1, container.get(i));
    }
    return max;
  }

  @Override
  protected Key max() {
    return container.get(0);
  }
}
