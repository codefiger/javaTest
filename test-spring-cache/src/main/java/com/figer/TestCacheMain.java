package com.figer;

import com.figer.config.CacheConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by figer on 8/15/16.
 */

public class TestCacheMain {
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
    /*ApplicationContext applicationContext = new ClassPathXmlApplicationContext("cache-context.xml");
    IProductService annotationService = applicationContext.getBean("productService", IProductService.class);
    new TestProcessor().testProductServiceWithCache(annotationService);*/

    //test div cache manager and cache
    //ApplicationContext divContext = new ClassPathXmlApplicationContext("div-cache-context.xml");
    //IProductService annotService = divContext.getBean("productService", IProductService.class);
    //new TestProcessor().testProductServiceWithCache(annotService);

    System.out.println("---------------ever proxy service line------------------");
    AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext(CacheConfig.class);
    IProductService everProxyService = annotationContext.getBean("proxyProductService", IProductService.class);
    new TestProcessor().testProductServiceWithCache(everProxyService);
  }

}
