package tictactoe;

public class TicTacToeRunner {
    public static void main(String[] args) {

        Game game = new Game();
        Player playerX = new Player("Player X", Sign.CROSS);
        Player playerO = new Player("Player O", Sign.NOUGHT);

        InputOutput inputOutput = new InputOutput();
        inputOutput.sayHello();
        inputOutput.displayBoard(game.getTheBoard());

        boolean end = false;

        while (!end) {

            Sign nextSign = game.checkWhosNext();

            int[] coordinates = inputOutput.getPlayerMove(playerO.getSign().equals(nextSign) ?
                        playerO : playerX);
                try {
                    game.putSignOnTheBoard(nextSign, coordinates[0], coordinates[1]);
                } catch (Exception e) {
                    System.out.println("Wrong move, baby! This field is already taken.");
                } finally {
                    inputOutput.displayBoard(game.getTheBoard());
                }

            if (game.checkIfBoardIsFull()) {
                System.out.println("Draw! No one wins, or both players are winners :)");
                end = true;
            }
        }
    }
}

