package com.figer.pattern.observer;

/**
 * Created by figer on 07/10/2016.
 */
public class ObserverClient {
  public static void main(String[] args) {
    Subject playHelpCenter = new PlayerHelpCenter();

    Observer redPlayer1,redPlayer2,redPlayer3,bluePlayer;
    redPlayer1 = new Player("redPlayer1", Player.Type.RED);
    redPlayer2 = new Player("redPlayer2", Player.Type.RED);
    redPlayer3 = new Player("redPlayer3", Player.Type.RED);
    bluePlayer = new Player("bluePlayer", Player.Type.BLUE);

    playHelpCenter.add(redPlayer1);
    playHelpCenter.add(redPlayer2);
    playHelpCenter.add(redPlayer3);
    playHelpCenter.add(bluePlayer);
    redPlayer1.callHelp(playHelpCenter);
  }
}
