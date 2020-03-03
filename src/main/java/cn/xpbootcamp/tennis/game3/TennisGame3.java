package cn.xpbootcamp.tennis.game3;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame3 implements TennisGame {

  private int player2Point;
  private int player1Point;
  private String player1Name;
  private String player2Name;

  public TennisGame3(String p1N, String p2N) {
    this.player1Name = p1N;
    this.player2Name = p2N;
  }

  @Override
  public void setPlayerPoint(int player1Point, int player2Point) {
    this.player1Point = player1Point;
    this.player2Point = player2Point;
  }

  public String getScore() {
    String[] description = new String[]{"Love", "Fifteen", "Thirty", "Forty"};

    if (isHighScore()) {
      if (isDraw()){
        return "Deuce";
      }

      return Math.abs(player1Point - player2Point) == 1 ?
              "Advantage " + getWinner() :
              "Win for " + getWinner();
    } else {
      return isDraw() ?
              description[player1Point] + "-All" :
              description[player1Point] + "-" + description[player2Point];
    }
  }

  private boolean isHighScore() {
    return player1Point >= 4 || player2Point >= 4 || player1Point + player2Point == 6;
  }

  private String getWinner() {
    return player1Point > player2Point ? player1Name : player2Name;
  }

  private boolean isDraw() {
    return player1Point == player2Point;
  }

}
