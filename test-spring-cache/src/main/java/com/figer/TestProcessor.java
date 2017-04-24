package com.figer;

import com.figer.config.SpringCacheConfig;
import com.figer.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by figer on 8/16/16.
 */
public class TestProcessor {
  SpringCacheConfig cacheConfig;

  public TestProcessor() {
  }

  public TestProcessor(SpringCacheConfig cacheConfig) {
    this.cacheConfig = cacheConfig;
  }

  public void testProductServiceWithCache(IProductService productService){
    System.out.println();
    System.out.println();
    System.out.println("[TestProcessor] start-------------");
    for(int i = 1; i < 6;i ++){
      System.out.println("get product times:" + i);
      System.out.println( productService.getProduct(new Long(i)));
    }

    productService.updateProduct(new Product(new Long(1)));
    cacheConfig.test();

    /*Product product = new Product(123L, "new productName");
    productService.updateProduct(product);
    System.out.println("get product times:6");
    System.out.println(productService.getProduct(123L));

    System.out.println(productService.getProduct(123L));

    productService.reloadCache();
    System.out.println(productService.getProduct(123L));

    //cache with condition
    System.out.println("====================null test with condition ");
    System.out.println(productService.getProductWithConditionCache(null));// no effort
    System.out.println(productService.getProductWithConditionCache(null));
    System.out.println("====================null test with condition ");
    System.out.println(productService.getProductWithConditionCache(123L));
    System.out.println(productService.getProductWithConditionCache(123L));

    System.out.println("===============exception===========");
    try {
      System.out.println(productService.getProductWithConditionCache(1230L));
    }catch (Exception e){
      e.printStackTrace();
    }
    try {
      System.out.println(productService.getProductWithConditionCache(1230L));
    }catch (Exception e){
      e.printStackTrace();
    }
    try {
      System.out.println(productService.getProductWithConditionCache(1230L));
    }catch (Exception e){
      e.printStackTrace();
    }
    System.out.println("===============exception===========");

    //caching data with multi params
    System.out.println("====================null test");
    System.out.println(productService.getProductWithMultiParams(null, "firstName"));// effort
    System.out.println(productService.getProductWithMultiParams(null, "firstName"));
    System.out.println("====================null test");
    System.out.println(productService.getProductWithMultiParams(123L, "firstName"));
    System.out.println(productService.getProductWithMultiParams(123L, "secondName"));
    System.out.println(productService.getProductWithMultiParams(333L, "secondName"));
    System.out.println(productService.getProductWithMultiParams(333L, "secondName"));
    System.out.println("[TestProcessor] end-------------");
  */
    //test cache proxy by aspectJ
    System.out.println("==================");
    System.out.println(productService.getProductDetail("first"));
    System.out.println(productService.getProductDetail("first"));

    /*try {
      Thread.sleep(100000L);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }*/
     /* System.out.println(productService.getProductDetail("first"));
    System.out.println(productService.getProductDetail("first"));
    System.out.println(productService.getProductDetail("first"));
    System.out.println(productService.getProductDetail("second"));
    //cacheConfig.evictProductCache();
    System.out.println(productService.getProductDetail("second"));
    System.out.println(productService.getProductDetail("second"));
    System.out.println(productService.getProductDetail("second"));

    System.out.println(productService.queryAllProducts());
    System.out.println(productService.queryAllProducts());
    System.out.println(productService.getProductDetail("peng.zhang"));
    System.out.println(productService.getProductWithConditionCache(1231L));
    System.out.println("======-resultUnless=====");
    System.out.println(productService.resultUnless(1230L));
    System.out.println(productService.resultUnless(1230L));
    System.out.println(productService.resultUnless(1230L));
    System.out.println(productService.resultUnless(1230L));
    System.out.println(productService.resultUnless(1230L));
    System.out.println(productService.resultUnless(1231L));
    System.out.println(productService.resultUnless(1232L));
    System.out.println(productService.resultUnless(1233L));
    System.out.println("--");
    System.out.println(productService.resultUnless(1231L));
    System.out.println(productService.resultUnless(1232L));
    System.out.println(productService.resultUnless(1233L));

    System.out.println("--");
    System.out.println(productService.resultUnless(1231L));
    System.out.println(productService.resultUnless(1232L));
    System.out.println(productService.resultUnless(1233L));
    System.out.println("--");
    System.out.println(productService.resultUnless(1231L));
    System.out.println(productService.resultUnless(1232L));
    System.out.println(productService.resultUnless(1233L));
    System.out.println("======-resultUnless=====");*/

    //productService.updateProduct(new Product());
    System.out.println("----end----");
  }

  public void testHighConcurrencyCache(final IProductService productService){
    System.out.println(productService.getProductWithConditionCache(1231L));
    System.out.println(productService.getProductWithConditionCache(1231L));

    //productService.getProductWithConditionCache(1231L);
    /*List<Callable<Integer>> callableBucket = new ArrayList<>();
    for (int i = 0; i < 34 ; i++) {
      callableBucket.add(new Callable<Integer>() {
        @Override
        public Integer call() throws Exception {
          System.out.println(productService.getProductWithConditionCache(1231L));
          return 1;
        }
      });
    }

    ExecutorService exec = Executors.newFixedThreadPool(10);
    try {
      exec.invokeAll(callableBucket);
    } catch (Exception e) {
      e.printStackTrace();
    }finally {
      if(!exec.isShutdown()){
        exec.shutdown();
      }
    }*/
  }


}
