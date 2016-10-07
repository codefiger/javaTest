package com.figer.pattern.observer;

/**
 * Created by figer on 07/10/2016.
 */
public class Player implements Observer {
  private String name;
  private Type type;
  private int signTimes;

  public Player(String name, Type type) {
    this.name = name;
    this.type = type;
  }

  public int getSignTimes() {
    return signTimes;
  }

  public void setSignTimes(int signTimes) {
    this.signTimes = signTimes;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public Type getType() {
    return type;
  }

  @Override
  public void callHelp(Subject subject) {
    subject.notifyObserver(this);
  }

  @Override
  public void help(Observer observer, Subject subject) {
    signTimes ++;
    System.out.println(name + ": copy that! I will go to help " + observer.getName());
    if(type == Type.BLUE){
      subject.notifyObserver(this);
    }
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    if(signTimes != 1) {
      signTimes = 0;
      System.out.println(name + ": I helped " + observer.getName());
    }
  }

  @Override
  public boolean equals(Object obj) {
    if(obj == null){
      return false;
    }

    if(!(obj instanceof Player)){
      return false;
    }

    Player newPlayer = (Player)obj;
    return this.name.equals(newPlayer.getName()) && this.type == newPlayer.getType();
  }

  @Override
  public int hashCode() {
    return name.hashCode()*31 + type.ordinal();
  }

  enum Type{
    RED,
    BLUE
  }
}
