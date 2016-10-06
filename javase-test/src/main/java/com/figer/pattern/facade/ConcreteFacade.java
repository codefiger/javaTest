package com.figer.pattern.facade;

/**
 * Created by figer on 10/6/16.
 */
public class ConcreteFacade extends AbstractFacade {
  private BeanA beanA;
  private BeanB beanB;
  private BeanC beanC;

  public ConcreteFacade(BeanA beanA, BeanB beanB, BeanC beanC) {
    this.beanA = beanA;
    this.beanB = beanB;
    this.beanC = beanC;
  }

  @Override
  public void synthesisApi() {
    beanA.doSomething();
    beanB.doSomething();
    beanC.doSomething();
  }
}
