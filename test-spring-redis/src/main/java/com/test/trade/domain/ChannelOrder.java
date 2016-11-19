package com.test.trade.domain;

import java.util.Date;
import java.util.List;

/**
 * Created by figer on 12/10/2016.
 */
public class ChannelOrder {
  private int id;
  private String commonOrderId;
  private String externalOrderId;
  private Integer statusId;
  private Integer tradeType;
  private String request;
  private String response;
  private Date createD;
  private List<ProductPurchaseOrder> productPurchaseOrderList;
}
