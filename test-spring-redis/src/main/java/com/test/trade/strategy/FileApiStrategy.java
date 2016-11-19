package com.test.trade.strategy;

import com.test.trade.OrderCreateRequest;

/**
 * Created by figer on 11/10/2016.
 */
public class FileApiStrategy implements IOrderTradeStrategy {
  @Override
  public Long purchaseAction(OrderCreateRequest request) {
    //1 save mysql db
    return null;
  }

  @Override
  public Long redeemAction(OrderCreateRequest request) {
    //1 save mysql db
    return null;
  }

  @Override
  public Long cancelAction(OrderCreateRequest request) {

    //1 save mysql db
    return null;
  }
}
