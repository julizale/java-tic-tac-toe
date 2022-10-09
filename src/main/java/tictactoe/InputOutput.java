package tictactoe;

import java.util.Scanner;

public class InputOutput {

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

    public char getUserInput (String message, String charactersAllowed) {
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

    public int[] getPlayerMove(Player player) {
        char row = getUserInput(player.getName() + ", what's Your move? Pick a row (1-3):",
                "123");
        char column = getUserInput("Good. Now please pick a column (1-3):",
                "123");
        return new int[] {Character.getNumericValue(row), Character.getNumericValue(column)};
    }

    public void sayHello() {
        System.out.println("Hello. Welcome to Tic Tac Toe Game");
    }
}
