package com.figer.pattern.state;

import java.math.BigDecimal;

/**
 * Created by figer on 07/10/2016.
 */
public class StateClient {
  public static void main(String[] args) {
    Account account = new Account(new NormalState(), BigDecimal.ONE, "figer");
    account.withdraw(new BigDecimal(100));

    account.withdraw(new BigDecimal(100));

    account.deposit(new BigDecimal(1000));

    for (int i = 0; i < 80; i++) {
      account.withdraw(BigDecimal.ONE);
    }
  }
}
