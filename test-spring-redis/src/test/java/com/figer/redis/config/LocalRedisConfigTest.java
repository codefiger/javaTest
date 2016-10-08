package com.figer.redis.config;

import com.figer.redis.LocalRedisConfig;
import static  org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by figer on 08/10/2016.
 */
@ContextConfiguration(classes = LocalRedisConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class LocalRedisConfigTest {
  @Autowired
  private RedisConnectionFactory jedisConnectionFactory;
  @Autowired
  private StringRedisTemplate redisTemplate;

  @Test
  public void testJedisConnectionFactory() {
    assertNotNull(jedisConnectionFactory);
  }

  @Test
  public void testRedisTemplate() {
    assertNotNull(redisTemplate);
  }

}
