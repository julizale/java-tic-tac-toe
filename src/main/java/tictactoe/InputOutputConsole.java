package tictactoe;

import java.util.Scanner;

public class InputOutputConsole {

    private final Scanner scanner = new Scanner(System.in);

    public String askForPlayerName () {
        System.out.println("What's Your name?");
        String playerName = scanner.nextLine();
        System.out.println("Hello " + playerName + "! Nice to meet You.");
        if (playerName.length() > 10) {
            playerName = playerName.substring(0, 10);
            System.out.println("Your name is very long. For the purpose of this game, You will be " +
                    playerName);
        }
        return playerName;
    }

    private char getUserInput (String message, String charactersAllowed) {
        System.out.println(message);
        char inputChar = '!';
        while (charactersAllowed.indexOf(inputChar) == -1) {
            inputChar = scanner.next().charAt(0);
        }
        return inputChar;
    }

    public void displayBoard(Sign[][] theBoard) {
        int size = theBoard.length;
        for (Sign[] signs : theBoard) {
            System.out.print("|");
            for (int column = 0; column < size; column++) {
                System.out.print(signs[column].toChar());
                System.out.print("|");
            }
            System.out.println();
        }
    }

    public int getPositiveIntegerFromPlayer(int upperBound, String message) {
        int number;
        do {
            System.out.println(message);
            while (!scanner.hasNextInt()) {
                System.out.println("Please type a numeric value!");
                scanner.next();
            }
            number = scanner.nextInt();
        } while (number <= 0 || number > upperBound);
        return number;
    }

    public int[] getPlayerMove(Player player, int boardSize) {
        int row = getPositiveIntegerFromPlayer(boardSize, player.getName() + ", Your move. Please pick a row.") - 1;
        int column = getPositiveIntegerFromPlayer(boardSize, "Now pick a column.") - 1;
        return new int[] {row, column};
    }

    public void announceWinner (Player player) {
        if (player.getName().equals("Computer")) {
            System.out.println("Computer wins.");
        } else {
            System.out.println("Congratulations, " + player.getName() + "! You win!");
        }
    }

    public void saySomething (String string) {
        System.out.println(string);
    }

    public int getBoardSideFromUser (Player player) {
        System.out.println("Welcome to TicTacToe Game.");
        char choice = getUserInput(player.getName() + ", do You want to play on small(3x3) or big(10x10) board? (b/s)",
                "sSbB");
        if (choice == 's' || choice == 'S') {
            return 3;
        }
        return 10;
    }
}
