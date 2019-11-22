package ohtu;

public class TennisGame {

    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void addPointToPlayer(String playerName) {
        if (playerName == player1Name) {
            player1Score += 1;
        } else {
            player2Score += 1;
        }
    }

    private String getSingleScoreString(int score) {
        switch (score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return "";
        }
    }

    private String getOverGameScoreString(int score1, int score2) {
        int scoreDifference = score1 - score2;
        if (scoreDifference == 1) {
            return "Advantage player1";
        } else if (scoreDifference == -1) {
            return "Advantage player2";
        } else if (scoreDifference >= 2) {
            return "Win for player1";
        } else if (scoreDifference == 0) {
            return "Deuce";
        } else {
            return "Win for player2";
        }
    }

    public String getScore() {
        String score = "";
        if (player1Score >= 4 || player2Score >= 4) {
            score = getOverGameScoreString(player1Score, player2Score);
        } else if (player1Score == player2Score) {
            score = getSingleScoreString(player1Score) + "-All";
        } else {
            score += getSingleScoreString(player1Score) + "-" + getSingleScoreString(player2Score);
        }
        return score;
    }
}
