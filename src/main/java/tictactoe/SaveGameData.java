package tictactoe;

import java.io.Serializable;

public record SaveGameData(String playerName, Integer playerRoundsWon, Integer computerRoundsWon, Integer roundsToWin,
                           Game game) implements Serializable {

}
