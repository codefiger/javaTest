package com.figer.cache.old;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by figer on 8/15/16.
 */
public class MyCacheManager<String, T> {
  private Map<String, T> cache = new ConcurrentHashMap<String, T>();

  public boolean put(String key, T t){
    try {
      cache.put(key, t);
      return true;
    }catch (Exception e){
      return false;
    }
  }

  public T get(String key){
    return  cache.get(key);
  }

  public boolean clearOne(String key){
    try {
      cache.remove(key);
      return true;
    } catch (Exception e){
      return false;
    }
  }

  public boolean clearCache(){
    try {
      cache.clear();
      return true;
    } catch (Exception e){
      return false;
    }
  }
}
