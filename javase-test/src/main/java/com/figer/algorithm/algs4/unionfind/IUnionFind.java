package com.figer.algorithm.algs4.unionfind;

/**
 * Created by figer on 11/05/2017.
 *
 * 触点：一个对象称作一个触点
 * 连接：输入的整数对 （具有对等关系：自反性，对称性以及传递性 ）
 * 等价类：当且仅当两个对象相连接时他们才属于同一个等价类，又称连通分量
 * 分量：即等价类
 *
 */
public interface IUnionFind {
  /**
   * 返回触点的分量标识符，在quick-union中返回root的标识符
   */
  int find(int component);

  /**
   * 判断触点P & Q是否连接
   */
  boolean connected(int componentP, int componentQ);

  /**
   * 连接触点P & Q
   */
  void union(int componentP, int componentQ);

  /**
   * return number of components
   */
  int count();
}
