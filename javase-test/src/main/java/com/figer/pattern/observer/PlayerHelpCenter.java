package com.figer.pattern.observer;

/**
 * Created by figer on 07/10/2016.
 */
public class PlayerHelpCenter extends Subject {
  @Override
  public void notifyObserver(Observer notifiedObserver) {
    System.out.println(notifiedObserver.getName() + " call for help,notify other player...");
    for(Observer observer : super.observers){
      if(!observer.equals(notifiedObserver)){
        observer.help(notifiedObserver, this);
      }
    }
  }
}
