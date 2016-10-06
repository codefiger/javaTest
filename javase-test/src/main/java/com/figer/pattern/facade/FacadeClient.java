package com.figer.pattern.facade;

/**
 * Created by figer on 10/6/16.
 */
public class FacadeClient {
  public static void main(String[] args) {
    BeanA beanA = new BeanA();
    BeanB beanB = new BeanB();
    BeanC beanC = new BeanC();

    AbstractFacade abstractFacade = new ConcreteFacade(beanA, beanB, beanC);
    abstractFacade.synthesisApi();
  }
}
