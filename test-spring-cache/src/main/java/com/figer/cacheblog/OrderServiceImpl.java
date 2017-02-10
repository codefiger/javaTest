package com.figer.cacheblog;

import com.figer.springframent.BeanSelfAware;
import org.springframework.aop.framework.AopContext;
import org.springframework.cache.annotation.Cacheable;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by figer on 12/23/2016.
 */
public class OrderServiceImpl implements IOrderService, BeanSelfAware {

  public @Cacheable String b(){
    return "invoke b";
  }

  public String a(){
    return this.b();
  }

  public String c(){
    return ((IOrderService)AopContext.currentProxy()).b();
  }

  private IOrderService proxyOrderService;
  @Override
  public void setSelf(Object proxyObject) {
    proxyOrderService = (IOrderService)proxyObject;
  }


  AtomicInteger index = new AtomicInteger(0);
  @Override
  public int getCallTimes() {
    return index.get();
  }

  @Override
  @Cacheable(value="orderCache", key = "#orderId", cacheManager = "cacheManager", sync = true)
  public String getOrder(String orderId) {
    index.addAndGet(1);
    System.out.println("query from db");
    return UUID.randomUUID().toString();
  }
}
