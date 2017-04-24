package com.figer.pattern.facade;

/**
 * Created by figer on 10/6/16.
 */
public class FacadeClient {
  public static void main(String[] args) {
    Hospital beanA = new Hospital();
    PoliceStation beanB = new PoliceStation();
    BeanC beanC = new BeanC();

    AbstractFacade abstractFacade = new ConcreteFacade(beanA, beanB, beanC);
    abstractFacade.doCertification();
  }
}
