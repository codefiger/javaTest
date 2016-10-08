package com.figer.redis.dao;

import com.figer.redis.LocalRedisConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static  org.junit.Assert.*;

/**
 * Created by figer on 08/10/2016.
 */
@ContextConfiguration(classes = LocalRedisConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class RedisCrudDaoTest {
  @Autowired
  private RedisCrudDao redisCrudDao;

  @Test
  public void test(){
    String key = "name";
    String value = "figer";

    redisCrudDao.delString(key);

    assertFalse(redisCrudDao.exists(key));

    redisCrudDao.saveString(key, value);

    assertTrue(redisCrudDao.exists(key));

    assertEquals(value, redisCrudDao.getString(key));
  }
}
