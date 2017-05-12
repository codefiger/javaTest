package com.figer.algorithm.algs4.unionfind;

/**
 * Created by figer on 11/05/2017.
 */
public class QuickUnionFind implements IUnionFind{
  private int ids[];// index -> 触点 , value ->  同一分量中其他触点标识符 （标识符即数组索引，如果分量只有自己，那值为自己的触点标识符）
  private int count;// 连通分量的数量

  public QuickUnionFind(int componentsNum) {
    ids = new int[componentsNum];
    count = componentsNum;//初始化时，所有的触点都是单个连接
    for (int i = 0; i < componentsNum; i++) {
      ids[i] = i;
    }
  }

  public int find(int component){
    while(component != ids[component]){
      component = ids[component];
    }
    return component;//返回root的标识符，无其他分量则返回自身的标识符
  }

  public boolean connected(int componentP, int componentQ){
    return find(componentP) == find(componentQ);
  }

  public void union(int componentP, int componentQ){
    if(connected(componentP, componentQ)){
      throw new UnsupportedOperationException(String.format("%d and %d have connected", componentP, componentQ));
    }else{
      int pRootID = find(componentP);
      int qRootID = find(componentQ);

      ids[pRootID] = qRootID;
      
      count --;
    }
  }

  public int count(){
    return count;
  }
}
