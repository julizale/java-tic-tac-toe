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

import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class TicTacToeGUIRunner extends Application {

    private final Image board10Image = new Image("file:src/main/resources/TicTacToe10Board.jpg");
    private final Image signCROSS = new Image("file:src/main/resources/signCROSS.png");
    private final Image signNOUGHT = new Image("file:src/main/resources/signNOUGHT.png");
    private final Image signBLANK = new Image("file:src/main/resources/signBLANK.png");
    private final Image board3Image = new Image("file:src/main/resources/TicTacToe3Board.jpg");
    private final Image signCROSS3 = new Image("file:src/main/resources/signCROSS100px.png");
    private final Image signNOUGHT3 = new Image("file:src/main/resources/signNOUGHT100px.png");
    private final Image signBLANK3 = new Image("file:src/main/resources/signBLANK100px.png");

    private Game game;
    private BackgroundSize backgroundSize = new BackgroundSize(100, 100,
            true, true, true, false);
    private GridPane grid;
    private Scene scene;
    private Stage myStage;
    private MenuBar menuBar;
    private boolean gameIsOn = false;

    @Override
    public void start(Stage primaryStage) throws Exception {

        myStage = primaryStage;
        myStage.setTitle("TicTacToe Game");
        myStage.setResizable(false);

        Menu menu = new Menu("Game");
        MenuItem menuItemNewGame3 = new MenuItem("New Game 3x3");
        MenuItem menuItemNewGame10 = new MenuItem("New Game 10");
        MenuItem menuItemQuitGame = new MenuItem("Quit Game");
        menu.getItems().add(menuItemNewGame3);
        menu.getItems().add(menuItemNewGame10);
        menu.getItems().add(menuItemQuitGame);
        menuItemNewGame3.setOnAction(e -> startGame3x3());
        menuItemNewGame10.setOnAction(e -> startGame10x10());
        menuItemQuitGame.setOnAction(e -> tryQuitGame());
        menuBar = new MenuBar();
        menuBar.getMenus().add(menu);

        startGame3x3();
    }

    private void startGame3x3 () {

        if (gameIsOn && !confirmAction("New game",
                "Do You really want to start new game?")) {
            return;
        }

        gameIsOn = false;
        game = new Game(3,3);
        grid = new GridPane();

        BackgroundImage backgroundImage = new BackgroundImage(board3Image,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setBackground(background);

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++){
                ImageView img = new ImageView(signBLANK3);
                grid.add(img, column, row);
                img.setPickOnBounds(true);
                img.addEventFilter(MouseEvent.MOUSE_PRESSED, event -> handleMousePress(img));
            }
        }

        BorderPane root = new BorderPane();
        root.setTop(menuBar);
        root.setCenter(grid);
        scene = new Scene(root, 380, 405, Color.BLACK);
        myStage.setScene(scene);
        myStage.show();
    }

    private void startGame10x10 () {

        if (gameIsOn && !confirmAction("New game",
                "Do You really want to start new game?")) {
            return;
        }

        gameIsOn = false;
        game = new Game(10,5);
        grid = new GridPane();

        BackgroundImage backgroundImage = new BackgroundImage(board10Image,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setBackground(background);

        for (int row = 0; row < 10; row++) {
            for (int column = 0; column < 10; column++){
                ImageView img = new ImageView(signBLANK);
                grid.add(img, column, row);
                img.setPickOnBounds(true);
                img.addEventFilter(MouseEvent.MOUSE_PRESSED, event -> handleMousePress(img));
            }
        }

        BorderPane root = new BorderPane();
        root.setTop(menuBar);
        root.setCenter(grid);
        scene = new Scene(root, 640, 665, Color.BLACK);
        myStage.setScene(scene);
        myStage.show();
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
            case NOUGHT -> "I win!";
            case BLANK -> "Draw!";
        };

        Alert popupGameOver = new Alert(Alert.AlertType.NONE);
        popupGameOver.setTitle("Game over");
        popupGameOver.setHeaderText(text);
        popupGameOver.setContentText("New game?");
        Image logo = new Image("file:src/main/resources/TicTacToeLogo.png");
        ImageView imageView = new ImageView(logo);
        popupGameOver.setGraphic(imageView);

        ButtonType buttonType3x3 = new ButtonType("New game 3x3");
        ButtonType buttonType10x10 = new ButtonType("New game 10x10");
        ButtonType buttonTypeQuit = new ButtonType("Quit game");

        popupGameOver.getButtonTypes().setAll(buttonType3x3, buttonType10x10, buttonTypeQuit);

        Optional<ButtonType> result = popupGameOver.showAndWait();
        if (result.isPresent()) {
            if (result.get() == buttonType3x3){
                startGame3x3();
            } else if (result.get() == buttonType10x10) {
                startGame10x10();
            } else {
                System.exit(0);
            }
        }
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
}
