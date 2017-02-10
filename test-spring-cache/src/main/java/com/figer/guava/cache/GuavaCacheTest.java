package com.figer.guava.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by figer on 02/12/2016.
 */
public class GuavaCacheTest {
  final String key = "key";
  String a = null;

  private String doRealService() {
    return UUID.randomUUID().toString();
  }

  //Cache的两种创建方式CacheLoader vs Callable
  @Test
  public void loadingCacheTest() throws Exception{
    LoadingCache<String, String> cache = CacheBuilder.newBuilder().build(new CacheLoader<String, String>() {
      @Override
      public String load(String key) throws Exception {
        return doRealService();
      }
    });
    assertEquals(cache.get(key), (cache.get(key)));
  }

  @Test
  public void callableCacheTest() throws Exception{
    System.out.println(""
        .concat(this.a));
    Cache<String, Object> cache = CacheBuilder.newBuilder().maximumSize(20).build();
    assertNull(cache.getIfPresent(key));
    assertEquals(cache.get(key, new Callable<String>() {
      @Override
      public String call() throws Exception {
        return doRealService();
      }
    }), cache.getIfPresent(key));
    assertEquals(cache.getIfPresent(key), cache.getIfPresent(key));
  }

  @Test
  public void testConcurrent() throws Exception{
    /*
    final Cache<String, Object> cache = CacheBuilder.newBuilder().maximumSize(20).build();

    final String key = "key";*/

    // Guava 解决了并发访问缓存问题
    List<Callable<Integer>> callableBucket = new ArrayList<>();
    final LoadingCache<String, Object> cache = CacheBuilder.newBuilder().build(new CacheLoader<String, Object>() {
      @Override
      public Object load(String key) throws Exception {
        return doService(key);
      }
    });

    final String key = "key";

    for (int i = 0; i < 10 ; i++) {
      callableBucket.add(new Callable<Integer>() {
        @Override
        public Integer call() throws Exception {
          System.out.println(cache.get(key));
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

  @Test
  public void guavaCacheDetailTest() throws Exception{
    final LoadingCache<String, Object> cache = CacheBuilder.newBuilder()
        .concurrencyLevel(10)//并发控制
        .expireAfterWrite(10, TimeUnit.SECONDS).expireAfterAccess(9, TimeUnit.SECONDS)//失效时间设置
        .initialCapacity(10).maximumSize(100)// 大小设置
        .weakKeys().weakValues().softValues()//引用设置
        .recordStats()//统计缓存的命中率
        .removalListener(new RemovalListener<Object, Object>() {
          @Override
          public void onRemoval(RemovalNotification<Object, Object> notification) {//缓存的移除通知
            System.out.println(notification.getKey() + " was removed, cause by " + notification.getCause());
          }
        })
        .build(
            new CacheLoader<String, Object>() {
              @Override
              public Object load(String key) throws Exception {
                return doService(key);
              }
            }
        );

    for (int i=0; i<20; i++) {
      cache.get(key);
      if(i % 4 == 0){
        cache.invalidate(key);
      }
    }

    System.out.println("========cache stats:" + cache.stats().toString());
  }

  private class ServiceCallback implements Callable<Object>{
    private String key;

    public ServiceCallback(String key) {
      this.key = key;
    }

    @Override
    public Object call() throws Exception {
      return doService(key);
    }
  }

  private Object doService(String key){
    System.out.println("=====do service===: " + key);
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return String.format("key:%s, val:%d", key, key.hashCode());
  }
}
