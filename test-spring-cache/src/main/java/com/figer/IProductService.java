package com.figer;

import com.figer.entity.Product;

/**
 * Created by figer on 8/15/16.
 */
public interface IProductService {
  Product getProduct(Long id);
  void updateProduct(Product product);
  void reloadCache();
}
