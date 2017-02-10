package com.figer.cache.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Created by figer on 25/11/2016.
 */
public class TestConcurrentHashMapCache<K,V> {
  private final ConcurrentHashMap<K, Future<V>>  cacheMap=new ConcurrentHashMap<>();

  public  Object getCache(K keyValue,String ThreadName){
    try {
      System.out.println("getCache==============ThreadName:"+ThreadName);
      Future<V> value = cacheMap.get(keyValue);
      if(value == null){
        value = putCache(keyValue, ThreadName);
      }
      return value.get();
    } catch (Exception e){
    }
    return null;
  }

  public Future<V> putCache(K keyValue, final String ThreadName){
    Future<V> value;
    Callable<V> callable = new Callable<V>() {
      @Override
      public V call() throws Exception {
        System.out.println("执行业务-访问数据库==============ThreadName:"+ThreadName);
        return (V)"dataValueFromDB";
      }
    };

    FutureTask<V> futureTask = new FutureTask(callable);
    value = cacheMap.putIfAbsent(keyValue, futureTask);
    if(value == null){
      value = futureTask;
      futureTask.run();
    }
    return value;
  }



  public static void main(String[] args) {
    final TestConcurrentHashMapCache<String,String> TestGuaVA=new TestConcurrentHashMapCache<String,String>();

    Thread t1=new Thread(new Runnable() {
      @Override
      public void run() {

        System.out.println("T1======start========");
        Object value=TestGuaVA.getCache("key","T1");
        System.out.println("T1 value=============="+value);
        System.out.println("T1======end========");

      }
    });

    Thread t2=new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("T2======start========");
        Object value=TestGuaVA.getCache("key","T2");
        System.out.println("T2 value=============="+value);
        System.out.println("T2======end========");

      }
    });

    Thread t3=new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("T3======start========");
        Object value=TestGuaVA.getCache("key","T3");
        System.out.println("T3 value=============="+value);
        System.out.println("T3======end========");

      }
    });

    t1.start();
    t2.start();
    t3.start();

  }

}