package tictactoe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Game implements Serializable {

    private Sign[][] theBoard;
    private final int numberOfSignsToWin;

    public Game(Sign[][] theBoard) {
        this.theBoard = theBoard;
        this.numberOfSignsToWin = 3;
    }

    public Game(Sign[][] theBoard, int numberOfSignsToWin) {
        this.theBoard = theBoard;
        this.numberOfSignsToWin = numberOfSignsToWin;
    }

    public Game(int boardSize, int numberOfSignsToWin) {
        this.numberOfSignsToWin = numberOfSignsToWin;
        createEmptyBoard(boardSize);
    }

    public void putSignOnTheBoard (Sign sign, int row, int column) throws OccupiedFieldException {
        if (theBoard[row][column] == Sign.BLANK) {
            theBoard[row][column] = sign;
        } else throw new OccupiedFieldException("Attempt to put a sign on a non-blank field.");
    }

    public Sign getSignFromTheBoard (int row, int column) {
        return theBoard[row][column];
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
        return getNumberOfSignsOnTheBoard(Sign.BLANK) == 0;
    }

    public int getNumberOfSignsOnTheBoard(Sign sign) {
        long count = Arrays.stream(theBoard)
                .flatMap(Arrays::stream)
                .filter(currentSign -> currentSign.equals(sign))
                .count();
        return (int) count;
    }

    public Sign checkWhosNext() {
        return getNumberOfSignsOnTheBoard(Sign.CROSS) > getNumberOfSignsOnTheBoard(Sign.NOUGHT) ?
                Sign.NOUGHT : Sign.CROSS;
    }

/*    private int[] findLongestSequenceOfXOnTheBoard() {
        //return coordinates of first and last


        //Check every column
        int[] longestSequenceColumns = {0, -1, -1}; // {x of first, y of first, x of last, y of last}
        for (int column = 0; column < theBoard.length; column++) {
            List<Sign> signsFromSingleColumn = new ArrayList<>();
            for (Sign[] signs : theBoard) {
                signsFromSingleColumn.add(signs[column]);
            }
            int[] tempResult = findLongestSignSequence(signsFromSingleColumn, Sign.CROSS);
            if (longestSequenceColumns[0] < tempResult[0]) {
                longestSequenceColumns[0] = tempResult[0];
                longestSequenceColumns[1] = tempResult[1];
                longestSequenceColumns[2] = tempResult[2];
            }
        }
        return result;
    }
    *//*public int[] makeNotSoRandomMove() {

        int[] xSequence = findLongestSequenceOfXOnTheBoard();
        //check if row or column or diagonal

        *//**//*List<int[]> listOfBlankFields = getAllBlankFields();
        Random generator = new Random();

        int coordinatesIndex = generator.nextInt(listOfBlankFields.size());
        try {
            putSignOnTheBoard(sign, listOfBlankFields.get(coordinatesIndex)[0], listOfBlankFields.get(coordinatesIndex)[1]);
        } catch (OccupiedFieldException e) {
            System.out.println("Error. Computer just tried to put a sign on an occupied field:" + e);
            System.exit(-1);
        }
        return listOfBlankFields.get(coordinatesIndex);*//**//*
    }*/
    public int[] findLongestSignSequence(List<Sign> signList, Sign theSign) {

        int count = 0;
        int posLast = -1;
        int posFirst = -1;
        int[] result = {count, posFirst, posLast};
        int[] tempResult = {count, posFirst, posLast};

        for (int i = 0; i < signList.size(); i++) {
            if (signList.get(i).equals(theSign)) {
                count++;
                posLast = i;
                if (posFirst < 0) {
                    posFirst = i;
                }
                tempResult[0] = count;
                tempResult[1] = posFirst;
                tempResult[2] = posLast;
            } else {
                if (result[0] < tempResult[0]) {
                    result[0] = tempResult[0];
                    result[1] = tempResult[1];
                    result[2] = tempResult[2];
                }
                count = 0;
                posFirst = -1;
            }
        }
        if (result[0] < tempResult[0]) {
            result[0] = tempResult[0];
            result[1] = tempResult[1];
            result[2] = tempResult[2];
        }
        return result;
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
        //Check diagonals left to right downward
        for (int column = numberOfSignsToWin - theBoard.length; column <= theBoard.length - numberOfSignsToWin; column++){
            List<Sign> signsFromDiagonalLeftToRight = new ArrayList<>();
            for (int row = 0; row < theBoard.length; row++) {
                if (column + row >= 0 && row + column < theBoard.length) {
                    signsFromDiagonalLeftToRight.add(theBoard[row][row + column]);
                }
            }
            Sign result = checkIfContainsSignsToWin(signsFromDiagonalLeftToRight);
            if (result != Sign.BLANK) {
                return result;
            }
        }
        //Check diagonals right to left downward
        for (int column = 2 * theBoard.length - numberOfSignsToWin - 1; column >= numberOfSignsToWin - 1; column--) {
            List<Sign> signsFromDiagonalRightToLeft = new ArrayList<>();
            for (int row = 0; row < theBoard.length; row++) {
                if (column - row < theBoard.length && column - row >= 0) {
                    signsFromDiagonalRightToLeft.add(theBoard[row][column - row]);
                }
            }
            Sign result = checkIfContainsSignsToWin((signsFromDiagonalRightToLeft));
            if (result != Sign.BLANK) {
                return result;
            }
        }

        return Sign.BLANK;
    }

    private Sign checkIfContainsSignsToWin (List<Sign> signList) {

        if (signList.size() < numberOfSignsToWin) {
            return Sign.BLANK;
        }

        int count = 0;
        Sign theSign = Sign.BLANK;

        for (Sign signFromTheList: signList) {
            if (signFromTheList.equals(Sign.BLANK)){
                count = 0;
                theSign = Sign.BLANK;
            } else if (signFromTheList.equals(theSign)) {
                count ++;
                if (count == numberOfSignsToWin) {
                    return theSign;
                }
            } else {
                theSign = signFromTheList;
                count = 1;
            }
        }

        return Sign.BLANK;
    }

    public int[] makeRandomMove (Sign sign) {
        List<int[]> listOfBlankFields = getAllBlankFields();
        Random generator = new Random();

        int coordinatesIndex = generator.nextInt(listOfBlankFields.size());
        try {
            putSignOnTheBoard(sign, listOfBlankFields.get(coordinatesIndex)[0], listOfBlankFields.get(coordinatesIndex)[1]);
        } catch (OccupiedFieldException e) {
            System.out.println("Error. Computer just tried to put a sign on an occupied field:" + e);
            System.exit(-1);
        }
        return listOfBlankFields.get(coordinatesIndex);
    }

    private List<int[]> getAllBlankFields() {
        List<int[]> blankFieldsList = new ArrayList<>();
        for (int row = 0; row < theBoard.length; row++) {
            for (int column = 0; column < theBoard.length; column++) {
                if (getSignFromTheBoard(row,column).equals(Sign.BLANK)) {
                    int[] coordinates = new int[] {row, column};
                    blankFieldsList.add(coordinates);
                }
            }
        }
        return blankFieldsList;
    }

}
