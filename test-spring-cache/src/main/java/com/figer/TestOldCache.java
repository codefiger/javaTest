package com.figer;

import com.figer.entity.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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


    System.out.println("I am a line------------------");
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("cache-context.xml");
    IProductService annotationService = applicationContext.getBean("productService", IProductService.class);
    for(int i = 1; i < 6;i ++){
      System.out.println("get product times:" + i);
      System.out.println( annotationService.getProduct(123L));
    }

    Product product = new Product(123L, "new productName");
    annotationService.updateProduct(product);
    System.out.println("get product times:6");
    System.out.println(annotationService.getProduct(123L));

    System.out.println(annotationService.getProduct(123L));

    annotationService.reloadCache();
    System.out.println(annotationService.getProduct(123L));
  }
}
