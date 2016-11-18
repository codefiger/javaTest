package com.figer.pattern.nullobject;

import java.math.BigDecimal;

/**
 * Created by figer on 18/11/2016.
 */
public interface IOrderService {
  Long create(BigDecimal amount);

  boolean execute(Long orderId);
}
