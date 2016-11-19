package com.test.trade;

import com.test.trade.strategy.ProductType;

/**
 * Created by figer on 11/10/2016.
 */
public class OrderCreateRequest {
  private TradeType tradeType;
  private ProductType productType;

  public TradeType getTradeType() {
    return tradeType;
  }

  public void setTradeType(TradeType tradeType) {
    this.tradeType = tradeType;
  }

  public ProductType getProductType() {
    return productType;
  }

  public void setProductType(ProductType productType) {
    this.productType = productType;
  }
}
