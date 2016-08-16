package com.figer;

import com.figer.entity.Product;

/**
 * Created by figer on 8/16/16.
 */
public class TestProcessor {
  public void testProductServiceWithCache(IProductService productService){
    System.out.println();
    System.out.println();
    System.out.println("[TestProcessor] start-------------");
    for(int i = 1; i < 6;i ++){
      System.out.println("get product times:" + i);
      System.out.println( productService.getProduct(123L));
    }

    Product product = new Product(123L, "new productName");
    productService.updateProduct(product);
    System.out.println("get product times:6");
    System.out.println(productService.getProduct(123L));

    System.out.println(productService.getProduct(123L));

    productService.reloadCache();
    System.out.println(productService.getProduct(123L));

    //cache with condition
    System.out.println(productService.getProductWithConditionCache(123L));
    System.out.println(productService.getProductWithConditionCache(123L));
    System.out.println(productService.getProductWithConditionCache(1230L));
    System.out.println(productService.getProductWithConditionCache(1230L));

    //caching data with multi params
    System.out.println(productService.getProductWithMultiParams(123L, "firstName"));
    System.out.println(productService.getProductWithMultiParams(123L, "secondName"));
    System.out.println(productService.getProductWithMultiParams(333L, "secondName"));
    System.out.println(productService.getProductWithMultiParams(333L, "secondName"));
    System.out.println("[TestProcessor] end-------------");
  }
}
