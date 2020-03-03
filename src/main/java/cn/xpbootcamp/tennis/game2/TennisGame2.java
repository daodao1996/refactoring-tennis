package cn.xpbootcamp.tennis.game2;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame2 implements TennisGame {
    public int player1Point = 0;
    public int player2Point = 0;

    public String play1Result = "";
    public String play2Result = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    @Override
    public void setPlayerPoint(int player1Point, int player2Point) {
        this.player1Point = player1Point;
        this.player2Point = player2Point;
    }

    public String getScore() {
        String score = "";
        if (player1Point == player2Point && player1Point < 4) {
            if (player1Point == 0)
                score = "Love";
            if (player1Point == 1)
                score = "Fifteen";
            if (player1Point == 2)
                score = "Thirty";
            score += "-All";
        }
        if (player1Point == player2Point && player1Point >= 3)
            score = "Deuce";

        if (player1Point > 0 && player2Point == 0) {
            if (player1Point == 1)
                play1Result = "Fifteen";
            if (player1Point == 2)
                play1Result = "Thirty";
            if (player1Point == 3)
                play1Result = "Forty";

            play2Result = "Love";
            score = play1Result + "-" + play2Result;
        }
        if (player2Point > 0 && player1Point == 0) {
            if (player2Point == 1)
                play2Result = "Fifteen";
            if (player2Point == 2)
                play2Result = "Thirty";
            if (player2Point == 3)
                play2Result = "Forty";

            play1Result = "Love";
            score = play1Result + "-" + play2Result;
        }

        if (player1Point > player2Point && player1Point < 4) {
            if (player1Point == 2)
                play1Result = "Thirty";
            if (player1Point == 3)
                play1Result = "Forty";
            if (player2Point == 1)
                play2Result = "Fifteen";
            if (player2Point == 2)
                play2Result = "Thirty";
            score = play1Result + "-" + play2Result;
        }
        if (player2Point > player1Point && player2Point < 4) {
            if (player2Point == 2)
                play2Result = "Thirty";
            if (player2Point == 3)
                play2Result = "Forty";
            if (player1Point == 1)
                play1Result = "Fifteen";
            if (player1Point == 2)
                play1Result = "Thirty";
            score = play1Result + "-" + play2Result;
        }

        if (player1Point > player2Point && player2Point >= 3) {
            score = "Advantage player1";
        }

        if (player2Point > player1Point && player1Point >= 3) {
            score = "Advantage player2";
        }

        if (player1Point >= 4 && player2Point >= 0 && (player1Point - player2Point) >= 2) {
            score = "Win for player1";
        }
        if (player2Point >= 4 && player1Point >= 0 && (player2Point - player1Point) >= 2) {
            score = "Win for player2";
        }
        return score;
    }
}
