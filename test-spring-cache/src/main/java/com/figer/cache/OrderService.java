package com.figer.cache;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Created by figer on 13/12/2016.
 */
public class OrderService {
  private static final ConcurrentHashMap<String, String> cache = new ConcurrentHashMap<>();
  public String getOrderById(String id){
    if(cache.containsKey(id)){
      return cache.get(id);
    }

    String result = doRealService(id);
    cache.putIfAbsent(id, result);
    return result;
  }

  private String doRealService(String id){
    System.out.println("query order from db");
    return "" + id;
  }

  //并发情况下可使用ConcurrentMap.putIfAbsent和Future的异步保证只执行一次service操作
  ConcurrentHashMap<String, Future<String>> futureCache = new ConcurrentHashMap<>();
  public String getOrder(String id) throws Exception{
    Future<String> future = futureCache.get(id);
    if(future == null){
      future = put(id);
    }
    return future.get();
  }

  private Future<String> put(final String key){
    Future<String> returnFuture;
    Callable<String> callable = new Callable<String>() {
      public String call() throws Exception {
        return doRealService(key);
      }
    };

    FutureTask<String> futureTask = new FutureTask<>(callable);
    returnFuture = futureCache.putIfAbsent(key, futureTask);
    if(returnFuture == null){
      returnFuture = futureTask;
      futureTask.run();
    }
    return returnFuture;
  }


  public static void main(String[] args) throws Exception{
    new OrderService().getOrderById("1");
    new OrderService().getOrder("1");
  }
}
