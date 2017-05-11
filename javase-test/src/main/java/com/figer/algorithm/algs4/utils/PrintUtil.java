package com.figer.algorithm.algs4.utils;

import com.alibaba.fastjson.JSON;

/**
 * Created by figer on 06/03/2017.
 */
public class PrintUtil {
  public void printJsonStr(Object obj){
    System.out.println(JSON.toJSONString(obj));
  }
}
