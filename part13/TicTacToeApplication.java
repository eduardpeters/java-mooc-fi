package ticTacToe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToeApplication extends Application {

    private GameState gameState = new GameState();

    @Override
    public void start(Stage window) {
        BorderPane layout = new BorderPane();

        Label gameInfo = new Label("Turn: X");
        gameInfo.setFont(Font.font("Monospaced", 40));

        layout.setTop(gameInfo);

        GridPane board = new GridPane();
        board.setVgap(10);
        board.setHgap(10);
        board.setPadding(new Insets(20, 20, 20, 20));
        Button squareOne = new TTTButton(gameState, gameInfo, 0, 0).getButton();
        Button squareTwo = new TTTButton(gameState, gameInfo, 1, 0).getButton();
        Button squareThree = new TTTButton(gameState, gameInfo, 2, 0).getButton();
        Button squareFour = new TTTButton(gameState, gameInfo, 0, 1).getButton();
        Button squareFive = new TTTButton(gameState, gameInfo, 1, 1).getButton();
        Button squareSix = new TTTButton(gameState, gameInfo, 2, 1).getButton();
        Button squareSeven = new TTTButton(gameState, gameInfo, 0, 2).getButton();
        Button squareEigth = new TTTButton(gameState, gameInfo, 1, 2).getButton();
        Button squareNine = new TTTButton(gameState, gameInfo, 2, 2).getButton();

        board.add(squareOne, 0, 0);
        board.add(squareTwo, 1, 0);
        board.add(squareThree, 2, 0);
        board.add(squareFour, 0, 1);
        board.add(squareFive, 1, 1);
        board.add(squareSix, 2, 1);
        board.add(squareSeven, 0, 2);
        board.add(squareEigth, 1, 2);
        board.add(squareNine, 2, 2);

        layout.setCenter(board);

        Scene view = new Scene(layout);
        window.setScene(view);
        window.show();

    }

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

}
