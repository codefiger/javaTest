package com.figer;

import com.figer.entity.Product;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
 * Created by figer on 8/15/16.
 */
public class AnnotationCacheProductService implements IProductService {

  @Override
  @Cacheable(value = "productCache")
  public Product getProduct(Long id) {
    System.out.println("get from db");
    return new Product(id, "productName");
  }

  @Override
  @Cacheable(value = "productCache", condition = "#id > 1000")
  public Product getProductWithConditionCache(Long id) {
    System.out.println("get from db");
    return new Product(id, "productName");
  }

  @Cacheable(value = "productCache", key = "#name.concat(#id)")
  public Product getProductWithMultiParams(Long id, String name) {
    System.out.println("get from db");
    return new Product(id, "productName");
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

}
