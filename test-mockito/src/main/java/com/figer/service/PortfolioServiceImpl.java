package com.figer.service;

import java.math.BigDecimal;

/**
 * Created by figer on 7/24/16.
 */
public class PortfolioServiceImpl implements PortfolioService{
  @Override
  public boolean purchase(Long userId, String portflolioId, BigDecimal amount) {
    System.out.println("invoke real implementation.");
    return false;
  }
}
