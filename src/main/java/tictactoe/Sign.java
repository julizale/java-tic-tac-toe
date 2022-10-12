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

    public String imagePathAndName() {
        return switch (this) {
            case BLANK -> "file:src/main/resources/signBLANK.png";
            case CROSS -> "file:src/main/resources/signCROSS.png";
            case NOUGHT -> "file:src/main/resources/signNOUGHT.png";
        };
    }

}
