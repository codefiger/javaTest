package com.figer;

import com.figer.entity.Product;

/**
 * Created by figer on 8/15/16.
 */
public interface IProductService {
  Product getProduct(Long id);
  Product getProductWithConditionCache(Long id);
  Product getProductWithMultiParams(Long id, String name);
  void updateProduct(Product product);
  void reloadCache();
}
