package tictactoe;

public class TicTacToeConsoleRunner {
    public static void main(String[] args) {

        InputOutputConsole inputOutput = new InputOutputConsole();
        Player playerX = new Player(inputOutput.askForPlayerName(), Sign.CROSS);
        Player computer = new Player("Computer", Sign.NOUGHT);
        int boardSize = inputOutput.getBoardSideFromUser(playerX);
        Game game = new Game(boardSize, boardSize == 10 ? 5 : 3);

        inputOutput.displayBoard(game.getTheBoard());

        boolean end = false;

        while (!end) {

            Sign nextSign = game.checkWhosNext();

            if (nextSign.equals(playerX.getSign())) {
                int currentStateOfBoard = game.getNumberOfSignsOnTheBoard(Sign.BLANK);
                while (currentStateOfBoard == game.getNumberOfSignsOnTheBoard(Sign.BLANK)) {
                    int[] coordinates = inputOutput.getPlayerMove(playerX, game.getTheBoard().length);
                    try {
                        game.putSignOnTheBoard(nextSign, coordinates[0], coordinates[1]);
                    } catch (Exception e) {
                        System.out.println("Wrong move, baby! This field is already taken.");
                    } finally {
                        inputOutput.displayBoard(game.getTheBoard());
                    }
                }
            } else {
                inputOutput.saySomething("Computer's move:");
                game.makeRandomMove(computer.getSign());
                inputOutput.displayBoard(game.getTheBoard());
            }

            Sign winigSign = game.checkIfWeHaveAWinner();

            if (game.checkIfBoardIsFull() && winigSign == Sign.BLANK) {
                System.out.println("Draw! No one wins, or both players are winners :)");
                end = true;
            }
            if (winigSign != Sign.BLANK) {
                inputOutput.announceWinner(computer.getSign().equals(winigSign) ?
                        computer : playerX);
                end = true;
            }
        }
    }
}

