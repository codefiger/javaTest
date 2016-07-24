package com.figer.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by figer on 7/24/16.
 */
@Service
public class PortfolioServiceImpl implements PortfolioService{
  @Override
  public boolean purchase(Long userId, String portflolioId, BigDecimal amount) {
    System.out.println("-------invoke real implementation.");
    return true;
  }
}
