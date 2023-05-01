package ticTacToe;

public class GameState {

    private boolean isXTurn;
    private boolean isFinalized;
    private int turnsElapsed;
    private int[][] board;
    private final int X_ID = 1;
    private final int O_ID = 2;

    public GameState() {
        this.isXTurn = true;
        this.isFinalized = false;
        this.turnsElapsed = 0;
        this.board = new int[3][3];
    }

    public boolean getXTurn() {
        return this.isXTurn;
    }

    public boolean getIsFinalized() {
        return this.isFinalized;
    }

    public int getTurns() {
        return this.turnsElapsed;
    }

    public int[][] getBoard() {
        return this.board;
    }

    public void takeTurn(int column, int row) {
        this.board[column][row] = this.isXTurn ? X_ID : O_ID;
        this.turnsElapsed += 1;
    }

    public void changeTurn() {
        this.isXTurn = !this.isXTurn;
    }

    public boolean isDraw() {
        if (this.turnsElapsed == 9) {
            this.isFinalized = true;
            return true;
        }
        return false;
    }

    public boolean isWinningMove() {
        // Check Rows
        for (int row = 0; row < this.board.length; row++) {
            if (isWinningRow(row)) {
                this.isFinalized = true;
                return true;
            }
        }
        // Check Columns
        for (int column = 0; column < this.board.length; column++) {
            if (isWinningColumn(column)) {
                this.isFinalized = true;
                return true;
            }
        }
        // Check Diagonals
        return isWinningDiagonals();
    }

    private boolean isWinningColumn(int column) {
        int countX = 0;
        int countO = 0;
        for (int row = 0; row < this.board.length; row++) {
            int value = this.board[column][row];
            if (value == this.X_ID) {
                countX += 1;
            } else if (value == this.O_ID) {
                countO += 1;
            }
        }
        return countX == 3 || countO == 3;
    }

    private boolean isWinningRow(int row) {
        int countX = 0;
        int countO = 0;
        for (int column = 0; column < this.board.length; column++) {
            int value = this.board[column][row];
            if (value == this.X_ID) {
                countX += 1;
            } else if (value == this.O_ID) {
                countO += 1;
            }
        }
        return countX == 3 || countO == 3;
    }

    private boolean isWinningDiagonals() {
        int countX = 0;
        int countO = 0;
        for (int d = 0; d < this.board.length; d++) {
            int value = this.board[d][d];
            if (value == this.X_ID) {
                countX += 1;
            } else if (value == this.O_ID) {
                countO += 1;
            }
        }
        if (countX == 3 || countO == 3) {
            return true;
        }

        countX = 0;
        countO = 0;
        for (int d = 0; d < this.board.length; d++) {
            int value = this.board[d][this.board.length - 1 - d];
            if (value == this.X_ID) {
                countX += 1;
            } else if (value == this.O_ID) {
                countO += 1;
            }
        }
        return countX == 3 || countO == 3;
    }
}
