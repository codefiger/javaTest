package com.figer.pattern.nullobject;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Created by figer on 18/11/2016.
 */
public class PurchaseOrderServiceImpl implements IOrderService {

  @Override
  public Long create(BigDecimal amount) {
    return (long)(new Random().nextInt(100));
  }

  @Override
  public boolean execute(Long orderId) {
    return orderId <= 1000L;
  }
}
