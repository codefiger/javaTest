package com.figer.algorithm.algs4.unionfind;

/**
 * Created by figer on 11/05/2017.
 */
public class UnionQuickFind implements IUnionFind{
  private int ids[];// index -> 触点 , value ->  分量的标识符 （标识符即数组索引,如果分量标识符相同，说明触点们在同一个分量中）
  private int count;// 连通分量的数量

  public UnionQuickFind(int componentsNum) {
    ids = new int[componentsNum];
    count = componentsNum;//初始化时，所有的触点都是单个连接
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
    if(connected(componentP, componentQ)){
      throw new UnsupportedOperationException(String.format("%d and %d have connected", componentP, componentQ));
    }else{
      int pID = find(componentP);
      int qID = find(componentQ);

      for (int i = 0; i < ids.length; i++) {
        if(pID == find(i)){
          ids[i] = qID;
        }
      }
      
      count --;
    }
  }

  public int count(){
    return count;
  }
}
