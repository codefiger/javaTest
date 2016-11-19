package com.test.trade.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by figer on 12/10/2016.
 */
public class ProductRedeemOrder {
  private Long id; //内部唯一标记号
  private String orderId; //对外订单号
  private Long aid;
  private Long productAssetId; //---对资产进行赎回
  private Long productId;
  private Integer productTypeId; //产品类型： p2p,fax...
  private Integer channelTypeId; //订单下单渠道:一个产品可能有多个渠道
  private String channelOrderId; //渠道表订单号
  private Integer orderStatusId; //

  private BigDecimal redeemShare; //赎回份额
  private BigDecimal confirmShare; //赎回确认份额
  private BigDecimal netValue; //赎回净值
  private BigDecimal redeemAmt; //赎回金额
  private BigDecimal confirmAmt; //赎回确认金额
  private BigDecimal tradeFee;
  //private Integer settlementStatusId; // UNSETTLED SETTLED

  private Date createD;
  private Date updateD;
  private Integer lastStatusId; //用于状态回滚使用，比如撤销操作失败，订单状态从canceling 变为原有状态
  private String errorMsg; //失败错误信息，冗余
  private String jsonInfo; //存储一些不太通用的信息
  private String productName; //冗余

}
