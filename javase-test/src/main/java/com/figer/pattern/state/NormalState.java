package com.figer.pattern.state;

import java.math.BigDecimal;

/**
 * Created by figer on 07/10/2016.
 */
public class NormalState extends AccountState {
  @Override
  public void withdraw(BigDecimal amount, Account account) {
    account.setBalance(account.getBalance().subtract(amount));
    System.out.println(String.format("Message: %s withdraw %s$", account.getAccountName(), account.getBalance().toString()));
    System.out.println(String.format("  And now your balance is %s", account.getBalance().toString()));
  }

  @Override
  public void deposit(BigDecimal amount, Account account) {
    account.setBalance(account.getBalance().add(amount));
    System.out.println(String.format("Message: %s deposit %s$", account.getAccountName(), account.getBalance().toString()));
    System.out.println(String.format("  And now your balance is %s", account.getBalance().toString()));
  }

  @Override
  public String toString() {
    return "NormalState";
  }
}
