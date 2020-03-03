package cn.xpbootcamp.tennis.game1;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame1 implements TennisGame {

  private int m_score1 = 0;
  private int m_score2 = 0;
  private String player1Name;
  private String player2Name;

  public TennisGame1(String player1Name, String player2Name) {
    this.player1Name = player1Name;
    this.player2Name = player2Name;
  }

  @Override
  public void setPlayerPoint(int p1Point, int p2Point) {
    this.m_score1 = p1Point;
    this.m_score2 = p2Point;
  }

  public String getScore() {

    if (m_score1 == m_score2) {
      if (m_score1 > 2) {
        return "Deuce";
      } else {
        return getPointDescription(m_score1) + "-All";
      }
    } else if (m_score1 >= 4 || m_score2 >= 4) {
      int minusResult = Math.abs(m_score1 - m_score2);
      String winner = getWinner();

      if (minusResult == 1) {
        return "Advantage " + winner;
      } else {
        return "Win for " + winner;
      }
    } else {
      return getPointDescription(m_score1) + "-" + getPointDescription(m_score2);
    }

  }

  private String getWinner() {
    return m_score1 - m_score2 > 0 ? player1Name : player2Name;
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
