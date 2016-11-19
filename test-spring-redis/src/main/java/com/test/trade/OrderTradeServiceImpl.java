package com.test.trade;

import com.test.trade.strategy.StrategyExecutor;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * Created by figer on 11/10/2016.
 */
public class OrderTradeServiceImpl implements IOrderTradeService {

  private StrategyExecutor strategyExecutor;

  //create
  @Override
  public Long purchase(OrderCreateRequest request) {
    return strategyExecutor.executePurchase(request);
  }

  @Override
  public Long redeem(OrderCreateRequest request) {
    return strategyExecutor.executeRedeem(request);
  }

  @Override
  public Long cancel(OrderCreateRequest request) {
    return strategyExecutor.executeCancel(request);
  }

  //query
  @Override
  @Cacheable
  public List<OrderRecord> queryTradeRecord(OrderQueryRequest request) {
    return null;
  }

  @Override
  @Cacheable
  public PurchaseOrderDetail purchaseDetail(Long orderId) {
    return null;
  }

  @Override
  @Cacheable
  public RedeemOrderDetail redeemDetail(Long orderId) {
    return null;
  }

}
