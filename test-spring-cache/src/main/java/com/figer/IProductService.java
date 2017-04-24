package com.figer;

import com.figer.entity.Product;
import org.springframework.cache.annotation.Cacheable;

/**
 * Created by figer on 8/15/16.
 */
public interface IProductService {
  @Cacheable(value = "productCache", key = "#id.toString()")
  Product getProduct(Long id);
  Product resultUnless(Long id);
  Product getProductWithConditionCache(Long id);
  Product getProductWithMultiParams(Long id, String name);
  String queryAllProducts();
  String aspectCacheTest(String name);
  String getProductDetail(String name);

  String queryAllProducts2();
  void updateProduct(Product product);
  void reloadCache();
}
