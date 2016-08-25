package com.figer;

import com.figer.springframent.BeanSelfAware;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.figer.entity.Product;

/**
 * Created by figer on 8/15/16.
 */
@Service(value = "proxyProductService")
public class InnerInvocationableProductService implements IProductService,BeanSelfAware {

  @Override
  public Product getProduct(Long id) {
    System.out.print("【get from db】");
    return new Product(id, "productName");
  }

  @Override
  @Cacheable(value = "productCache", condition = "#id > 1000")
  public Product getProductWithConditionCache(Long id) {
    System.out.print("【get from db】");
    return new Product(id, "productName");
  }

  @Cacheable(value = "productCache")
  public Product getProductWithMultiParams(Long id, String name) {
    System.out.print("【get from db】");
    return new Product(id, "productName");
  }

  @Override
  @Cacheable(value = "productCache")
  public String queryAllProducts() {
    System.out.print("【get from db】");
    return "queryAllProducts";
  }

  @Override
  public String getProductDetail(String name) {
    return proxySelf.aspectCacheTest(name);
  }

  @Override
  @Cacheable(value = "productCache")
  public String queryAllProducts2() {
    System.out.println("------queryAllProducts2----");
    return "queryAllProducts2";
  }

  @Cacheable(value = "productCache")
  public String aspectCacheTest(String name){
    System.out.print("【get from db】");
    return "test : " + name;
  }

  @CacheEvict(value="productCache",key="#product.getId()")
  public void updateProduct(Product product) {
    updateDB(product);
  }

  @Override
  @CacheEvict(value = "productCache",allEntries = true, beforeInvocation = true)
  public void reloadCache() {

  }

  private void updateDB(Product product) {
    System.out.println("update product : " + product.getName());
  }


  private InnerInvocationableProductService proxySelf;
  @Override
  public void setSelf(Object proxyObject) {
    this.proxySelf = (InnerInvocationableProductService)proxyObject;
  }
}
