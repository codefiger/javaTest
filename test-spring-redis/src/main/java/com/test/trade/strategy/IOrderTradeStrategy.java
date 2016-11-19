package com.test.trade.strategy;

import com.test.trade.OrderCreateRequest;

/**
 * Created by figer on 11/10/2016.
 */
public interface IOrderTradeStrategy {
  Long purchaseAction(OrderCreateRequest request);
  Long redeemAction(OrderCreateRequest request);
  Long cancelAction(OrderCreateRequest request);
}
