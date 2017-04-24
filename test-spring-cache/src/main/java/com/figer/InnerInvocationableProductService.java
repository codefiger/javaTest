package com.figer;

import org.springframework.aop.framework.AopContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.figer.entity.Product;

/**
 * Created by figer on 8/15/16.
 */
@Service(value = "proxyProductService")
public class InnerInvocationableProductService implements IProductService {
  private boolean throwException = true;
  private boolean test = true;

  @Override
  public Product getProduct(Long id) {
    System.out.print("【get from db】");
    return new Product(id, "productName");
  }

  @Override
  @Cacheable(value = "productCache", unless = "#result == null", key = "'' + #id")//不cache result == null的情况
  public Product resultUnless(Long id) {
    System.out.print("【get from db】");
    if(test){
      test = false;
      return null;
    }
    return new Product(id, "resultUnless");
  }


  @Override
  @Cacheable(value = "productCache",  key = "'' + #id")
  public Product getProductWithConditionCache(Long id) {
    System.out.print("【get from db】");
    return new Product(id, "productName");
  }

  @Cacheable(value = Example.cacheName)
  public Product getProductWithMultiParams(Long id, String name) {
    System.out.print("【get from db】");
    return new Product(id, "productName");
  }

  @Override
  @Cacheable(value = "another", key = "'testteststsetsetsetsetset'")
  public String queryAllProducts() {
    System.out.print("==================【get from db】");
    return "queryAllProducts---------";
  }

  @Override
  public String getProductDetail(String name) {
    return ((IProductService)AopContext.currentProxy()).aspectCacheTest(name);
  }

  @Override
  @Cacheable(value = "productCache")
  public String queryAllProducts2() {
    System.out.println("------queryAllProducts2----");
    return "queryAllProducts2";
  }

  @Cacheable(value = "another")
  public String aspectCacheTest(String name){
    System.out.print("【get from db】");
    return "test : " + name;
  }

  @CacheEvict(value = "productCache" , key = "#product.id.toString()")
  public void updateProduct(Product product) {
    updateDB(product);
  }

  @Override
  @CacheEvict(value = Example.cacheName,allEntries = true, beforeInvocation = true)
  public void reloadCache() {

  }

  private void updateDB(Product product) {
    System.out.println("update product : " + product.getName());
  }


  /*private InnerInvocationableProductService proxySelf;
  @Override
  public void setSelf(Object proxyObject) {
    this.proxySelf = (InnerInvocationableProductService)proxyObject;
  }*/
}
