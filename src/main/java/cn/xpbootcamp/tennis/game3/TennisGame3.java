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
        String s;
        if (player1Point < 4 && player2Point < 4 && !(player1Point + player2Point == 6)) {
            String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
            s = p[player1Point];
            return (player1Point == player2Point) ? s + "-All" : s + "-" + p[player2Point];
        } else {
            if (player1Point == player2Point)
                return "Deuce";
            s = player1Point > player2Point ? player1Name : player2Name;
            return ((player1Point - player2Point)*(player1Point - player2Point) == 1) ? "Advantage " + s : "Win for " + s;
        }
    }

}
