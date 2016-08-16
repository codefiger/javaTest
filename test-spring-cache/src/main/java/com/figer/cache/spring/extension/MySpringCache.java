package com.figer.cache.spring.extension;

import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by figer on 8/16/16.
 */
public class MySpringCache implements Cache{
  private String name;
  private Map<String, Object> nativeCache = new ConcurrentHashMap<String, Object>();

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public Object getNativeCache() {
    return nativeCache;
  }

  @Override
  public ValueWrapper get(Object key) {
    ValueWrapper value = null;
    Object obj = nativeCache.get(key.toString());
    if(obj != null){
      System.out.println("------cache return :" + obj);
      value = new SimpleValueWrapper(obj);
    }
    return value;
  }

  @Override
  public void put(Object key, Object value) {
    nativeCache.put(key.toString(), value);
  }

  @Override
  public void evict(Object key) {
    nativeCache.remove(key);
  }

  @Override
  public void clear() {
    nativeCache.clear();
  }
}
