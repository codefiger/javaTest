package com.figer;

import com.figer.entity.Product;
import org.springframework.cache.annotation.Cacheable;

/**
 * Created by figer on 8/15/16.
 */
public interface IProductService {
  @Cacheable(value = "productCache", key = "#id", cacheManager = "guavaCacheManager")
  Product getProduct(Long id);
  Product getProductWithConditionCache(Long id);
  Product getProductWithMultiParams(Long id, String name);
  String queryAllProducts();
  String getProductDetail(String name);

  String queryAllProducts2();
  void updateProduct(Product product);
  void reloadCache();
}
