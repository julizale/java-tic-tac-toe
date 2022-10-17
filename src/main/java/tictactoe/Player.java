package tictactoe;

public class Player {

    private final String name;
    private final Sign sign;
    private int gamesWon;

    public Player(final String name, final Sign sign) {
        this.name = name;
        this.sign = sign;
        gamesWon = 0;
    }

    public String getName() {
        return name;
    }

    public Sign getSign() {
        return sign;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }
}
