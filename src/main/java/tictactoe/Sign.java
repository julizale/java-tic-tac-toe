package tictactoe;

public enum Sign {

    BLANK,
    CROSS,
    NOUGHT;

    public char toChar() {
        return switch (this) {
            case BLANK -> ' ';
            case CROSS -> 'X';
            case NOUGHT -> 'O';
        };
    }


}
