package com.figer.pattern.nullobject;

import java.math.BigDecimal;

/**
 * Created by figer on 18/11/2016.
 */
public class NullOrderService implements Sender {
  @Override
  public Long create(BigDecimal amount) {
    return null;
  }

  @Override
  public boolean execute(Long orderId) {
    return false;
  }
}
