package com.figer.redis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

/**
 * Created by figer on 08/10/2016.
 */
@Repository
public class RedisCrudDao {
  @Autowired
  private StringRedisTemplate stringRedisTemplate;

  public void saveString(String key, String value){
    stringRedisTemplate.opsForValue().set(key, value);
  }

  public String getString(String key){
    return stringRedisTemplate.opsForValue().get(key);
  }

  public void delString(String key){
    stringRedisTemplate.delete(key);
  }

  public boolean exists(String key){
    return !StringUtils.isEmpty(stringRedisTemplate.opsForValue().get(key));
  }
}
