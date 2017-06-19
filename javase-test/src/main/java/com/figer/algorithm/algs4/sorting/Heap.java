package com.figer.algorithm.algs4.sorting;

/**
 * Created by figer on 17/06/2017.
 */
public class Heap extends SortTemplate {

  @Override
  public void sort(Comparable[] array, int low, int high) {
    //TODO： bug
    int N = high - low + 1;
    for (int i = N/2; i >= low; i--) {
      adjustDownToUp(array, i, N);
    }

    while (N > low + 1){
      exch(array, low, --N);
      adjustDownToUp(array, low, N);
    }
  }

  private void sink(Comparable array[], int k, int N){
    while(2*k <= N){
      int i = 2*k;
      if(i < N && less(i, i + 1)){
        i++;
      }
      if(!less(k, i)){
        break;
      }else {
        exch(array, i, k);
        k = i;
      }
    }
  }

  //将元素array[k]自下往上逐步调整树形结构
  private void adjustDownToUp(Comparable[] array,int k,int length){
    Comparable temp = array[k];
    for(int i=2*k+1; i<length-1; i=2*i+1){    //i为初始化为节点k的左孩子，沿节点较大的子节点向下调整
      if(i<length && less(array[i],array[i+1])){  //取节点较大的子节点的下标
        i++;   //如果节点的右孩子>左孩子，则取右孩子节点的下标
      }
      if(!less(temp,array[i])){  //根节点 >=左右子女中关键字较大者，调整结束
        break;
      }else{   //根节点 <左右子女中关键字较大者
        array[k] = array[i];  //将左右子结点中较大值array[i]调整到双亲节点上
        k = i; //【关键】修改k值，以便继续向下调整
      }
    }
    array[k] = temp;  //被调整的结点的值放人最终位置
  }
}
