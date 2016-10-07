package com.figer.pattern.observer;

/**
 * Created by figer on 07/10/2016.
 */
public interface Observer {
  int getSignTimes();

  void setSignTimes(int signTimes);
  String getName();
  void setName(String name);
  Player.Type getType();
  void callHelp(Subject subject);
  void help(Observer observer, Subject subject);
}
