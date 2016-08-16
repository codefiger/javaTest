package com.figer;

import com.figer.cache.old.MyCacheManager;
import com.figer.entity.Product;

/**
 * Created by figer on 8/15/16.
 */
public class ProductService implements IProductService{
  private static final MyCacheManager<String, Product> productCache = new MyCacheManager<String, Product>();

  public Product getProduct(Long id){
    Product cache = productCache.get(id.toString());
    if(cache == null){
      System.out.println("  get product from db");
      Product product = new Product(id, "productName");
      productCache.put(id.toString(), product);
      return product;
    }else{
      System.out.println("  get product from cache");
      return cache;
    }
  }

  @Override
  public void updateProduct(Product product) {

  }

  @Override
  public void reloadCache() {

  }

  public MyCacheManager<String, Product> getProductCache() {
    return productCache;
  }
}
