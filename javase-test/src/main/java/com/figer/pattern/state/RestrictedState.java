package com.figer.pattern.state;

import java.math.BigDecimal;

/**
 * Created by figer on 07/10/2016.
 */
public class RestrictedState extends AccountState {
  @Override
  public void withdraw(BigDecimal amount, Account account) {
    System.out.println(String.format("Message: Limited withdraw cause your account is restricted"));
  }

  @Override
  public void deposit(BigDecimal amount, Account account) {
    System.out.println(String.format("Message: Limited deposit cause your account is restricted"));
  }

  @Override
  public String toString() {
    return "RestrictedState";
  }
}
