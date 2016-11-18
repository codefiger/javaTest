package com.figer.pattern.nullobject;

/**
 * Created by figer on 18/11/2016.
 */
public class OrderServiceFactory {

  public enum OrderType{
    purchase
  }

  public IOrderService getService(OrderType orderType){
    if(orderType == OrderType.purchase){
      return new PurchaseOrderServiceImpl();
    }else{
      return new NullOrderService();
    }
  }
}
