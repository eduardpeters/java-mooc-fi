package ticTacToe;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class TTTButton {

    private GameState gameState;
    private Label gameInfo;
    int column;
    int row;

    public TTTButton(GameState gameState, Label gameInfo, int column, int row) {
        this.gameState = gameState;
        this.gameInfo = gameInfo;
        this.column = column;
        this.row = row;
    }

    public Button getButton() {

        Button square = new Button(" ");
        square.setFont(Font.font("Monospaced", 40));

        square.setOnAction((event) -> {
            if (!square.getText().isBlank() || this.gameState.getIsFinalized()) {
                return;
            }
            if (this.gameState.getXTurn()) {
                square.setText("X");
                this.gameInfo.setText("Turn: O");
            } else {
                square.setText("O");
                this.gameInfo.setText("Turn: X");
            }
            this.gameState.takeTurn(this.column, this.row);
            if (this.gameState.isWinningMove()) {
                this.gameInfo.setText("The end!");
            } else if (this.gameState.isDraw()) {
                this.gameInfo.setText("Draw!");
            }
            this.gameState.changeTurn();
        });

        return square;
    }

}
