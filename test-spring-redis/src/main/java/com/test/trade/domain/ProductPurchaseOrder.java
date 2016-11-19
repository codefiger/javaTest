package com.test.trade.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by figer on 12/10/2016.
 */
public class ProductPurchaseOrder {
  private Long id; //内部唯一标记号
  private String orderId; //对外订单号，如果是做幂等接口，可以考虑通过接口从外部传入
  private Long aid;
  private Long productId;
  private Integer productTypeId; //产品类型： p2p,fax...
  private Integer channelTypeId; //订单下单渠道:一个产品可能有多个渠道，后续根据渠道对接三方
  private String channelOrderId; //渠道表订单号
  private Integer orderStatusId; //

  private BigDecimal purchaseAmt;
  private BigDecimal confirmAmt;
  private BigDecimal confirmShare; //固守类不设置，值为null
  private BigDecimal tradeFee;
  //private Integer settlementStatusId;// UNSETTLED SETTLED
  private Date createD;
  private Date updateD;
  private Integer lastStatusId; //用于状态回滚使用，比如撤销操作失败，订单状态从canceling 变为原有状态
  private String errorMsg; //失败错误信息，冗余
  private String productName; //冗余
  private String jsonInfo; //存储一些不太通用的信息

}
