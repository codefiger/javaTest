package com.figer;

import com.figer.entity.Product;
import org.springframework.cache.annotation.Cacheable;

/**
 * Created by figer on 8/15/16.
 */
public class AnnotationCacheProductService implements IProductService{

  @Override
  @Cacheable(value = "productCache")
  public Product getProduct(Long id) {
    System.out.println("get from db");
    return new Product(id, "productName");
  }
}
