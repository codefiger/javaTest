package com.figer.pattern.state;

import java.math.BigDecimal;

/**
 * Created by figer on 07/10/2016.
 */
public abstract class AccountState {
  public abstract void withdraw(BigDecimal amount, Account account);
  public abstract void deposit(BigDecimal amount, Account account);
}
