package com.figer.algorithm.algs4.unionfind;

/**
 * Created by figer on 11/05/2017.
 */
public class UnionQuickFindWithoutCost implements IUnionFind{
  private int ids[];// index -> 触点 , value ->  组号 （标识符即数组索引,如果组号相同，说明节点们在同一个组中）
  private int count;// 集合的数量

  public UnionQuickFindWithoutCost(int componentsNum) {
    ids = new int[componentsNum];
    count = componentsNum;//初始化时，所有的节点都是单个集合
    for (int i = 0; i < componentsNum; i++) {
      ids[i] = i;
    }
  }

  public int find(int component){
    return ids[component];
  }

  public boolean connected(int componentP, int componentQ){
    return find(componentP) == find(componentQ);
  }

  public void union(int componentP, int componentQ){
    int pID = find(componentP);
    int qID = find(componentQ);

    for (int i = 0; i < ids.length; i++) {
      if(pID == find(i)){
        ids[i] = qID;
      }
    }
    count --;
  }

  public int count(){
    return count;
  }
}
