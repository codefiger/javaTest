package com.figer.cache.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Created by figer on 25/11/2016.
 */
public class ConcurrentCache<K,V> {
  private final ConcurrentHashMap<K, Future<V>> concurrentMap = new ConcurrentHashMap<>();

  private ConcurrentHashMap<K,V> simpleMap = new ConcurrentHashMap();

  public V simpleGet(K key){
    V v = simpleMap.get(key);
    if(v == null){
      v = simplePut(key);
    }
    return v;
  }

  public V simplePut(K key){
    queryDB(key);
    V v = simpleMap.putIfAbsent(key, (V)"db value");
    return v == null ? (V)"db value" : v;
  }

  public V get(K key){
    Future<V> future = concurrentMap.get(key);
    if(future == null){
      future = put(key);
    }
    V v = null;

    try {
      v = future.get();
    } catch (Exception e) {
    }

    return v;
  }

  private Future<V> put(final K key){
    Future<V> returnFuture;

    Callable<V> callable = new Callable<V>() {
      @Override
      public V call() throws Exception {
        queryDB(key);
        return (V) "db value";
      }
    };

    FutureTask<V> futureTask = new FutureTask<>(callable);
    returnFuture = concurrentMap.putIfAbsent(key, futureTask);
    if(returnFuture == null){
      returnFuture = futureTask;
      futureTask.run();
    }

    return returnFuture;
  }

  private void queryDB(K key){
    //TODO: execute service here
    System.out.println(String.format("execute biz - query %s from db - thread %s", key, Thread.currentThread().getName()));
  }

  public static void main(String[] args) {
    final ConcurrentCache<String, String> concurrentCache = new ConcurrentCache<>();
    final String key = "key";

    List<Callable<Integer>> callableBucket = new ArrayList<>();
    for (int i = 0; i < 10 ; i++) {
      callableBucket.add(new Callable<Integer>() {
        @Override
        public Integer call() throws Exception {
          System.out.println(concurrentCache.get(key));// high concurrency cache
          //System.out.println(concurrentCache.simpleGet(key));
          return 1;
        }
      });
    }

    ExecutorService exec = Executors.newFixedThreadPool(10);
    try {
      exec.invokeAll(callableBucket);
    } catch (Exception e) {
      e.printStackTrace();
    }finally {
      if(!exec.isShutdown()){
        exec.shutdown();
      }
    }
  }
}
