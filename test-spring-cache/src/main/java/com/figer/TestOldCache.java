package com.figer;

/**
 * Created by figer on 8/15/16.
 */

public class TestOldCache {
  public static void main(String[] args) {
    ProductService service = new ProductService();
    for(int i = 1; i < 3;i ++){
      System.out.println("get product times:" + i);
      service.getProduct(123L);
    }


    service.getProductCache().clearCache();
    System.out.println("clear cache");
    service.getProduct(123L);
  }
}
