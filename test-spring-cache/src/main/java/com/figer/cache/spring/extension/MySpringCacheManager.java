package com.figer.cache.spring.extension;

import org.springframework.cache.Cache;
import org.springframework.cache.support.AbstractCacheManager;

import java.util.Collection;

/**
 * Created by figer on 8/16/16.
 */
public class MySpringCacheManager extends AbstractCacheManager{
  private Collection<? extends MySpringCache> caches;

  @Override
  protected Collection<? extends Cache> loadCaches() {
    return caches;
  }

  public void setCaches(Collection<? extends MySpringCache> caches) {
    this.caches = caches;
  }
}
