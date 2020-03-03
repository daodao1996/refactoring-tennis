package cn.xpbootcamp.tennis.game1;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame1 implements TennisGame {

  private int player1Point = 0;
  private int player2Point = 0;
  private String player1Name;
  private String player2Name;

  public TennisGame1(String player1Name, String player2Name) {
    this.player1Name = player1Name;
    this.player2Name = player2Name;
  }

  @Override
  public void setPlayerPoint(int p1Point, int p2Point) {
    this.player1Point = p1Point;
    this.player2Point = p2Point;
  }

  public String getScore() {

    if (isDraw()) {
      return getScoreWhenDraw();
    } else if (isHighPoint()) {
      return getScoreWhenHighPoint();
    } else {
      return getPointDescription(player1Point) + "-" + getPointDescription(player2Point);
    }

  }

  private String getScoreWhenHighPoint() {
    int minusResult = Math.abs(player1Point - player2Point);
    String score = "";

    if (minusResult == 1) {
      score += "Advantage ";
    } else {
      score += "Win for ";
    }
    return score + getWinner();
  }

  private boolean isHighPoint() {
    return player1Point >= 4 || player2Point >= 4;
  }

  private String getScoreWhenDraw() {
    if (player1Point > 2) {
      return "Deuce";
    } else {
      return getPointDescription(player1Point) + "-All";
    }
  }

  private boolean isDraw() {
    return player1Point == player2Point;
  }

  private String getWinner() {
    return player1Point - player2Point > 0 ? player1Name : player2Name;
  }

  private String getPointDescription(int point) {
    switch (point) {
      case 0:
        return "Love";
      case 1:
        return "Fifteen";
      case 2:
        return "Thirty";
      default:
        return "Forty";
    }
  }
}
