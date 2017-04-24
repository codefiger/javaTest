package com.figer.pattern.facade;

/**
 * Created by figer on 10/6/16.
 */
public class ConcreteFacade extends AbstractFacade {
  private Hospital beanA;
  private PoliceStation beanB;
  private BeanC beanC;

  public ConcreteFacade(Hospital beanA, PoliceStation beanB, BeanC beanC) {
    this.beanA = beanA;
    this.beanB = beanB;
    this.beanC = beanC;
  }

  @Override
  public void doCertification() {
    beanA.doCertification();
    beanB.doInnocentCertification();
    beanC.doSomething();
  }
}
