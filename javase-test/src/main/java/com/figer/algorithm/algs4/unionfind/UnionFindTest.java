package com.figer.algorithm.algs4.unionfind;

import com.figer.algorithm.algs4.utils.CostDraw;
import com.figer.algorithm.algs4.utils.In;
import com.figer.algorithm.algs4.utils.StdIn;
import com.figer.algorithm.algs4.utils.StdOut;

/**
 * Created by figer on 11/05/2017.
 */
public class UnionFindTest {
  public static void main(String[] args) {
    //StdIn.resyncSystemInByFile(args[0]);
    In in = new In(args[0]);
    int nums[] = in.readAllInts();

    int componentNum = nums[0];
    CostDraw costDraw = new CostDraw();
    IUnionFind unionFind = new UnionQuickFind(componentNum);
    drawCost(nums, componentNum, unionFind, costDraw);

    unionFind.resetCost();
    unionFind = new QuickUnionFind(componentNum);
    drawCost(nums, componentNum, unionFind, costDraw);

    unionFind.resetCost();
    unionFind = new WeightedQuickUnionFindWithCost(componentNum);
    drawCost(nums, componentNum, unionFind, costDraw);
  }

  public static void drawCost(int nums[], int componentNum, IUnionFind unionFind, CostDraw costDraw){
    int index = 0;
    while (index < componentNum){
      int p = nums[index + 1];
      int q = nums[index + 2];

      if(!unionFind.connected(p, q)){
        unionFind.union(p, q);
      }
      costDraw.drawPoint(index++, unionFind.getCount()/index);
    }

  }

}
