package tictactoe;

public class OccupiedFieldException extends Exception {

    public OccupiedFieldException(String message) {
        super(message);
    }
}
