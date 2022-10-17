package tictactoe;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.*;
import java.util.Optional;

public class TicTacToeGUIRunner extends Application {

    private final Image board10Image = new Image("file:src/main/resources/TicTacToe10Board.jpg");
    private final Image signCROSS = new Image("file:src/main/resources/signCROSS.png");
    private final Image signNOUGHT = new Image("file:src/main/resources/signNOUGHT.png");
    private final Image signBLANK = new Image("file:src/main/resources/signBLANK.png");
    private final Image board3Image = new Image("file:src/main/resources/TicTacToe3Board.jpg");
    private final Image signCROSS3 = new Image("file:src/main/resources/signCROSS100px.png");
    private final Image signNOUGHT3 = new Image("file:src/main/resources/signNOUGHT100px.png");
    private final Image signBLANK3 = new Image("file:src/main/resources/signBLANK100px.png");
    private final File savedGame = new File("savegame.data");

    private Game game;
    private final BackgroundSize backgroundSize = new BackgroundSize(100, 100,
            true, true, true, false);
    private GridPane grid;
    private Stage myStage;
    private MenuBar menuBar;
    private Label gameStatusLabel;
    private HBox hBox;
    private boolean gameIsOn = false;
    private Player computer  = new Player("Computer", Sign.NOUGHT);
    private Player player = new Player("Player", Sign.CROSS);
    private int numberOfRoundsToWin = 0;

    @Override
    public void start(Stage primaryStage) {

        myStage = primaryStage;
        myStage.setTitle("TicTacToe Game");
        myStage.setResizable(false);

        startGame();
    }

    private void startGame3x3 () {

        gameIsOn = false;
        game = new Game(3,3);

        stagePrepareAndShow();
    }

    private void startGame3x3FromLoadedState (SaveGameData saveGameData) {

        player = new Player(saveGameData.playerName(), Sign.CROSS);
        computer.setGamesWon(saveGameData.computerRoundsWon());
        player.setGamesWon(saveGameData.playerRoundsWon());
        numberOfRoundsToWin = (saveGameData.roundsToWin());
        game = (saveGameData.game());

        gameIsOn = game.getNumberOfSignsOnTheBoard(Sign.BLANK) != 9;

        stagePrepareAndShow();
    }

    private void startGame10x10 () {

        gameIsOn = false;
        game = new Game(10,5);

        stagePrepareAndShow();
    }

    private void startGame10x10FromLoadedState (SaveGameData saveGameData) {

        player = new Player(saveGameData.playerName(), Sign.CROSS);
        computer.setGamesWon(saveGameData.computerRoundsWon());
        player.setGamesWon(saveGameData.playerRoundsWon());
        numberOfRoundsToWin = (saveGameData.roundsToWin());
        game = (saveGameData.game());

        gameIsOn = game.getNumberOfSignsOnTheBoard(Sign.BLANK) != 100;

        stagePrepareAndShow();
    }

    private void handleMousePress (ImageView img) {
        int boardSize = grid.getColumnCount();
        int imgRow = GridPane.getRowIndex(img);
        int imgColumn = GridPane.getColumnIndex(img);

        boolean fieldWasBlank = true;
        try {
            game.putSignOnTheBoard(Sign.CROSS, imgRow, imgColumn);
        } catch (OccupiedFieldException exception) {
            fieldWasBlank = false;
        }
        if (fieldWasBlank) {
            gameIsOn = true;
            img.setImage(boardSize == 10 ? signCROSS : signCROSS3);
            if (game.checkIfWeHaveAWinner() == Sign.BLANK) {
                if (!game.checkIfBoardIsFull()) {
                    int[] coordinates = game.makeRandomMove(Sign.NOUGHT);
                    grid.add(new ImageView(boardSize == 10 ? signNOUGHT : signNOUGHT3),
                            coordinates[1], coordinates[0]);
                    if (game.checkIfWeHaveAWinner() == Sign.NOUGHT) {
                        announceWinner(Sign.NOUGHT);
                    }
                }
                if (game.checkIfBoardIsFull()) {
                    announceWinner(Sign.BLANK);
                }
            } else {
                announceWinner(Sign.CROSS);
            }
        }
    }

    public void announceWinner (Sign sign) {
        gameIsOn = false;

        String text = switch (sign) {
            case CROSS -> "Congratulations! You won!";
            case NOUGHT -> "Computer wins.";
            case BLANK -> "Draw!";
        };

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game over");
        alert.setHeaderText(text);
        alert.showAndWait();

        if (sign.equals(Sign.CROSS)) {
            player.setGamesWon(player.getGamesWon() + 1);
            if (player.getGamesWon() == numberOfRoundsToWin) {
                updateStatusLabel();
                announceTotalWinner (player);
            }
        } else if (sign.equals(Sign.NOUGHT)) {
            computer.setGamesWon(computer.getGamesWon() + 1);
            if (computer.getGamesWon() == numberOfRoundsToWin) {
                updateStatusLabel();
                announceTotalWinner (computer);
            }
        }

        if (game.getTheBoard().length == 3) {
            startGame3x3();
        } else startGame10x10();
    }

    private void tryQuitGame() {
        if (gameIsOn && !confirmAction("Quit game",
                "Do You really want to quit game?")) {
            return;
        }
        System.exit(0);
    }

    private boolean confirmAction (String title, String contentText) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setContentText(contentText);

        Optional<ButtonType> result = alert.showAndWait();
        return (result.isPresent()) && (result.get() == ButtonType.OK);
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void createMenu () {
        Menu menuGame = new Menu("Game");
        MenuItem menuItemNewGame = new MenuItem("New Game");
        MenuItem menuItemQuitGame = new MenuItem("Quit Game");
        Menu subMenuLoadSave = new Menu("Save/Load");
        MenuItem menuItemSaveGame = new MenuItem("Save Game");
        MenuItem menuItemLoadGame = new MenuItem("Load Game");
        subMenuLoadSave.getItems().add(menuItemSaveGame);
        subMenuLoadSave.getItems().add(menuItemLoadGame);
        menuGame.getItems().add(menuItemNewGame);
        menuGame.getItems().add(subMenuLoadSave);
        menuGame.getItems().add(menuItemQuitGame);
        menuItemNewGame.setOnAction(e -> startGame());
        menuItemSaveGame.setOnAction(e -> saveGame());
        menuItemLoadGame.setOnAction(e -> loadGame());
        menuItemQuitGame.setOnAction(e -> tryQuitGame());

        menuBar = new MenuBar();
        menuBar.getMenus().add(menuGame);
    }

    private String askForPlayerName () {
        TextInputDialog textDialog = new TextInputDialog("Player");
        textDialog.setTitle("Enter name");
        textDialog.setHeaderText("What's Your name?");
        textDialog.setContentText("Please enter Your name (max 10 letters)");
        textDialog.showAndWait();
        String playerName = (textDialog.getEditor().getText());

        if (playerName.length() > 10) {
            playerName = playerName.substring(0, 10);
        }
        return playerName;
    }

    private int askForNumberOfRounds () {
        Integer[] numbers = {1, 2, 3, 4, 5};
        ChoiceDialog<Integer> dialog = new ChoiceDialog<>(numbers[2], numbers);
        dialog.setTitle("Number of rounds");
        dialog.setHeaderText("Please choose:");
        dialog.setContentText("Number of rounds to win:");
        dialog.showAndWait();
        return dialog.getSelectedItem();
    }

    private void announceTotalWinner (Player player) {
        Alert popupGameOver = new Alert(Alert.AlertType.NONE);
        popupGameOver.setTitle("Game over");
        popupGameOver.setHeaderText(player.getName() + " wins!");
        popupGameOver.setContentText("New game?");
        Image logo = new Image("file:src/main/resources/TicTacToeLogo.png");
        ImageView imageView = new ImageView(logo);
        popupGameOver.setGraphic(imageView);

        ButtonType buttonTypeNewGame = new ButtonType("New game");
        ButtonType buttonTypeQuit = new ButtonType("Quit game");

        popupGameOver.getButtonTypes().setAll(buttonTypeNewGame, buttonTypeQuit);

        Optional<ButtonType> result = popupGameOver.showAndWait();
        if (result.isPresent()) {
            if (result.get().equals(buttonTypeNewGame)) {
                try {
                    gameIsOn = false;
                    player.setGamesWon(0);
                    computer.setGamesWon(0);
                    start(myStage);
                } catch (Exception e) {
                    System.out.println("Exception while running javafx start method again " + e);
                }
            } else {
                System.exit(0);
            }

        }
    }

    private void startGame() {
        if (computer.getGamesWon() != 0 || player.getGamesWon() != 0 || gameIsOn) {
            if (!confirmAction("New game", "Do You really want to start new game?")) {
                return;
            }
        }

        computer = new Player("Computer", Sign.NOUGHT);
        player = new Player(askForPlayerName(), Sign.CROSS);
        numberOfRoundsToWin = askForNumberOfRounds();

        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.setTitle("New Game");
        alert.setHeaderText("Choose size of the board.");
        Image logo = new Image("file:src/main/resources/TicTacToeLogo.png");
        ImageView imageView = new ImageView(logo);
        alert.setGraphic(imageView);

        ButtonType buttonType3x3 = new ButtonType("3x3");
        ButtonType buttonType10x10 = new ButtonType("10x10");

        alert.getButtonTypes().setAll(buttonType3x3, buttonType10x10);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent()) {
            if (result.get().equals(buttonType3x3)) {
                startGame3x3();
            } else {
                startGame10x10();
            }
        }
    }

    private void updateStatusLabel() {
        gameStatusLabel.setText(player.getName() + ": " + player.getGamesWon() +
                " Computer: " + computer.getGamesWon());
    }

    private void createHBox() {
        hBox = new HBox();
        hBox.setSpacing(20);
        hBox.setAlignment(Pos.CENTER_LEFT);
        hBox.getChildren().add(menuBar);
        gameStatusLabel = new Label();
        Label numberOfRoundsToWinLabel = new Label("Rounds to win: " + numberOfRoundsToWin);
        hBox.getChildren().add(gameStatusLabel);
        hBox.getChildren().add(numberOfRoundsToWinLabel);
        updateStatusLabel();
    }

    private void saveGame() {
        if (computer.getGamesWon() == 0 && player.getGamesWon() == 0 && !gameIsOn) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No data to save");
            alert.setHeaderText("Start playing, before you can save game.");
            alert.showAndWait();
            return;
        }
        SaveGameData saveGameData = new SaveGameData(player.getName(), player.getGamesWon(), computer.getGamesWon(),
                numberOfRoundsToWin, game);

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(savedGame))) {
            oos.writeObject(saveGameData);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Game Saved");
            alert.setHeaderText("Game saved successfully");
            alert.showAndWait();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Error saving file");
            alert.setContentText(String.valueOf(e));
            alert.showAndWait();
        }
    }

    private void loadGame() {
        if (computer.getGamesWon() != 0 || player.getGamesWon() != 0 || gameIsOn) {
            if (confirmAction("Load game", "Do you really want to quit current game?")) {
                try {
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(savedGame));
                    Object readSavedGame = ois.readObject();
                    if(readSavedGame instanceof SaveGameData) {
                        if (((SaveGameData) readSavedGame).game().getTheBoard().length == 3) {
                            startGame3x3FromLoadedState((SaveGameData) readSavedGame);
                        } else {
                            startGame10x10FromLoadedState((SaveGameData) readSavedGame);
                        }
                    }
                    ois.close();
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error");
                    alert.setHeaderText("Error reading file");
                    alert.setContentText(String.valueOf(e));
                    alert.showAndWait();
                }
            }
        }
    }

    private void createGridPane() {

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        int boardSize = game.getTheBoard().length;

        BackgroundImage backgroundImage;
        if (boardSize == 3) {
            backgroundImage = new BackgroundImage(board3Image, BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        } else {
            backgroundImage = new BackgroundImage(board10Image, BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        }
        Background background = new Background(backgroundImage);
        grid.setBackground(background);

        for (int row = 0; row < boardSize; row++) {
            for (int column = 0; column < boardSize; column++){
                ImageView img;
                if (boardSize == 3) {
                    img = switch (game.getSignFromTheBoard(row, column)) {
                        case BLANK -> new ImageView(signBLANK3);
                        case CROSS -> new ImageView(signCROSS3);
                        case NOUGHT -> new ImageView(signNOUGHT3);
                    };
                } else {
                    img = switch (game.getSignFromTheBoard(row, column)) {
                        case BLANK -> new ImageView(signBLANK);
                        case CROSS -> new ImageView(signCROSS);
                        case NOUGHT -> new ImageView(signNOUGHT);
                    };
                }
                grid.add(img, column, row);
                img.setPickOnBounds(true);
                img.addEventFilter(MouseEvent.MOUSE_PRESSED, event -> handleMousePress(img));
            }
        }
    }

    private void stagePrepareAndShow() {

        createMenu();
        createGridPane();
        createHBox();
        BorderPane root = new BorderPane();
        root.setTop(hBox);
        root.setCenter(grid);
        Scene scene;
        if (game.getTheBoard().length == 3) {
            scene = new Scene(root, 380, 405, Color.BLACK);
        } else {
            scene = new Scene(root, 640, 665, Color.BLACK);
        }
        myStage.setScene(scene);
        myStage.show();
    }
}

