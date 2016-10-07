package com.figer.pattern.state;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Created by figer on 07/10/2016.
 */
public class Account {
  private AccountState state;
  private BigDecimal balance;
  private String accountName;

  public Account(AccountState state, BigDecimal balance, String accountName) {
    this.state = state;
    this.balance = balance;
    this.accountName = accountName;
  }

  private static final Random random = new Random();

  public void withdraw(BigDecimal amount){
    state.withdraw(amount, this);
    stateCheck();
  }

  public void deposit(BigDecimal amount){
    state.deposit(amount, this);
    stateCheck();
  }

  public void stateCheck(){
    if(state instanceof  RestrictedState){
      return;
    }

    if(random.nextInt(100) < 1){
      state = new RestrictedState();
      return;
    }

    if (balance.compareTo(BigDecimal.ZERO) <= 0) {
      state = new OverdraftState();
    }else {
      state = new NormalState();
    }

    System.out.println("Now your account is " + state);
  }

  public AccountState getState() {
    return state;
  }

  public void setState(AccountState state) {
    this.state = state;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }

  public String getAccountName() {
    return accountName;
  }

  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }
}
