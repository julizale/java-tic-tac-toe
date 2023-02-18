package tictactoe;

public class SignSequence {

    private final Sign sign;
    private final int firstColumn;
    private final int firstRow;
    private final int lastColumn;
    private final int lastRow;

    public SignSequence(final Sign sign, final int firstColumn,
                        final int firstRow, final int lastColumn, final int lastRow) {
        this.sign = sign;
        this.firstColumn = firstColumn;
        this.firstRow = firstRow;
        this.lastColumn = lastColumn;
        this.lastRow = lastRow;
    }

    public Sign getSign() {
        return sign;
    }

    public int getFirstColumn() {
        return firstColumn;
    }

    public int getFirstRow() {
        return firstRow;
    }

    public int getLastColumn() {
        return lastColumn;
    }

    public int getLastRow() {
        return lastRow;
    }

    public int getLength() {
        return lastColumn > firstColumn ? lastColumn - firstColumn + 1 :
                lastRow > firstRow ? lastRow - firstRow + 1 :
                        firstColumn > lastColumn ? firstColumn - lastColumn + 1 : firstRow - lastRow + 1;
    }

}
