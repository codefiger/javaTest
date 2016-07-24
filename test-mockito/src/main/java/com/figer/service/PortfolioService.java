package com.figer.service;

import java.math.BigDecimal;

/**
 * Created by figer on 7/24/16.
 */
public interface PortfolioService {
  boolean purchase(Long userId, String portfolioId, BigDecimal amount);
}
