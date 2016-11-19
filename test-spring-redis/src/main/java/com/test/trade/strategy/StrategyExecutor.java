package com.test.trade.strategy;

import com.test.trade.OrderCreateRequest;
import com.test.trade.domain.ChannelStrategy;

import java.util.List;

/**
 * Created by figer on 11/10/2016.
 */
public class StrategyExecutor {
  private IOrderTradeStrategy fileApiStrategy;
  private IOrderTradeStrategy requestChannelStrategy;
  private IOrderTradeStrategy withoutChannelStrategy;


  public Long executePurchase(OrderCreateRequest request){
    IOrderTradeStrategy strategy = getStrategy(request);
    return strategy.purchaseAction(request);
  }

  public Long executeRedeem(OrderCreateRequest request){
    IOrderTradeStrategy strategy = getStrategy(request);
    return strategy.redeemAction(request);
  }

  public Long executeCancel(OrderCreateRequest request){
    IOrderTradeStrategy strategy = getStrategy(request);
    return strategy.cancelAction(request);
  }

  private IOrderTradeStrategy getStrategy(OrderCreateRequest orderCreateRequest){
    // 考虑不同的产品有多个渠道，每种渠道对应不同的处理策略
    ChannelStrategy channelStrategy = getChannelStrategy(orderCreateRequest.getProductType());


    switch (channelStrategy) {
      case api_channel:
        return requestChannelStrategy;
      case file_channel:
        return fileApiStrategy;
      case without_channel:
        return withoutChannelStrategy;
      default:
        return null;
    }
  }

  private ChannelStrategy getChannelStrategy(ProductType productType) {
    List<ChannelStrategy> channelStrategyList = getFromDB(productType);
    return channelStrategyList.get(0);
  }


  private List<ChannelStrategy> getFromDB(ProductType productType) {
    return null;
  }


}
