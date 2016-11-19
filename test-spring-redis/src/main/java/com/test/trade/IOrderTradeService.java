package com.test.trade;

import java.util.List;

/**
 * Created by figer on 11/10/2016.
 */
public interface IOrderTradeService {
  Long purchase(OrderCreateRequest request);

  Long redeem(OrderCreateRequest request);

  Long cancel(OrderCreateRequest request);

  List<OrderRecord> queryTradeRecord(OrderQueryRequest request);

  PurchaseOrderDetail purchaseDetail(Long orderId);

  RedeemOrderDetail redeemDetail(Long orderId);
}
