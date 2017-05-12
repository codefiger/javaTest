package com.figer.algorithm.algs4.unionfind;

import com.figer.algorithm.algs4.utils.StdIn;
import com.figer.algorithm.algs4.utils.StdOut;

/**
 * Created by figer on 11/05/2017.
 */
public class UnionFindTest {
  public static void main(String[] args) {
    int componentNum = StdIn.readInt();
    IUnionFind unionFind = new WeightedQuickUnionFind(componentNum);

    int p;
    while ((p = StdIn.readInt()) != -1){
      System.out.println("p:" + p);
      int q = StdIn.readInt();

      if(!unionFind.connected(p, q)){
        unionFind.union(p, q);
        StdOut.println(p + "," + q);
      }
      System.out.println(unionFind.count() + " components left");
    }


  }
}
