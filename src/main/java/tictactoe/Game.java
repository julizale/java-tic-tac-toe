package tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

    //private Map<Character, List<FieldContent>> theBoard;
    private Sign[][] theBoard;
    private int numberOfSignsToWin;

    public Game() {
        createEmptyBoard(3);
        this.numberOfSignsToWin = 3;
    }

    public Game(Sign[][] theBoard) {
        this.theBoard = theBoard;
        this.numberOfSignsToWin = 3;
    }

    public void putSignOnTheBoard (Sign sign, int row, int column) throws Exception {
        if (theBoard[row - 1][column - 1] == Sign.BLANK) {
            theBoard[row - 1][column - 1] = sign;
        } else throw new Exception();
    }

    public Sign getSignFromTheBoard (int row, int column) {
        return theBoard[row - 1][column - 1];
    }

    private void createEmptyBoard (int size) {
        theBoard = new Sign[size][size];
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                theBoard[row][column] = Sign.BLANK;
            }
        }
    }

    public Sign[][] getTheBoard() {
        return theBoard;
    }

    public boolean checkIfBoardIsFull () {
        long blanks = Arrays.stream(theBoard)
                .flatMap(Arrays::stream)
                .filter(sign -> sign.equals(Sign.BLANK))
                .count();
        return blanks == 0;
    }

    public Sign checkWhosNext() {
        long sumOfX = Arrays.stream(theBoard)
                .flatMap(Arrays::stream)
                .filter(sign -> sign.equals(Sign.CROSS))
                .count();
        long sumOfO = Arrays.stream(theBoard)
                .flatMap(Arrays::stream)
                .filter(sign -> sign.equals(Sign.NOUGHT))
                .count();
        return sumOfX > sumOfO ? Sign.NOUGHT : Sign.CROSS;
    }

    public Sign checkIfWeHaveAWinner() {
        //Check every row
        for (Sign[] row: theBoard) {
            List<Sign> signsFromSingleRow = new ArrayList<>(Arrays.asList(row));
            Sign result = checkIfContainsSignsToWin(signsFromSingleRow);
            if (result != Sign.BLANK) {
                return result;
            }
        }
        //Check every column
        for (int column = 0; column < theBoard.length; column++) {
            List<Sign> signsFromSingleColumn = new ArrayList<>();
            for (Sign[] signs : theBoard) {
                signsFromSingleColumn.add(signs[column]);
            }
            Sign result = checkIfContainsSignsToWin(signsFromSingleColumn);
            if (result != Sign.BLANK) {
                return result;
            }
        }

        //temporarily return BLANK
        return Sign.BLANK;
    }

    private Sign checkIfContainsSignsToWin (List<Sign> signList) {
        if (signList.size() < numberOfSignsToWin) {
            return Sign.BLANK;
        }

        int count = 0;
        Sign theSign = Sign.BLANK;

        for (Sign signFromList: signList) {
            if (signFromList.equals(Sign.BLANK)){
                count = 0;
                theSign = Sign.BLANK;
            } else if (signFromList.equals(theSign)) {
                count ++;
                if (count == numberOfSignsToWin) {
                    return theSign;
                }
            } else {
                theSign = signFromList;
                count = 1;
            }
        }

        return Sign.BLANK;
    }
}
