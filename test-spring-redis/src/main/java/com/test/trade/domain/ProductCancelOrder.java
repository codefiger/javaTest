package com.test.trade.domain;

import java.util.Date;

/**
 * Created by figer on 12/10/2016.
 */
public class ProductCancelOrder {
  private Long id; //内部唯一标记号
  private Long aid;
  private String orderId; //对外订单号
  private String channelOrderId; //渠道表订单号
  private Long purchaseOrderId;
  private Long redeemOrderId;
  private Integer channelId; //订单下单渠道:一个产品可能有多个渠道
  private Integer orderStatusId;//
  private Date createD;
}
