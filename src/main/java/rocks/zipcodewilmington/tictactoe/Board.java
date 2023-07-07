package rocks.zipcodewilmington.tictactoe;

/**
 * @author leon on 6/22/18.
 */
public class Board {
    private Character[][] gameBoard;

    public Board(Character[][] matrix) {
        this.gameBoard = matrix;
    }

    public Boolean isInFavorOfX() {
        // check diagonal
        // check rows
        // check cols
        return checkDiagonal('X') || checkCols('X') || checkRows('X');
    }

    public Boolean isInFavorOfO() {
        return checkDiagonal('O') || checkCols('O') || checkRows('O');
    }

    public Boolean isTie() {
        return !isInFavorOfX() && !isInFavorOfO();
    }

    /*
     * returns "" when there is no winner AKA a tie
     */
    public String getWinner() {
        if (isTie()) {
            return "";
        } else if (isInFavorOfO()) {
            return "O";
        } else if (isInFavorOfX()) {
            return "X";
        }
        return null;
    }

    private boolean checkDiagonal(char player) {
        // check \ diagonal
        if (areEqual(player, 0, 0) && areEqual(player, 1, 1)
                && areEqual(player, 2, 2)) {
            return true;
        }
        // check / diagonal
        if (areEqual(player, 2, 0) && areEqual(player, 1, 1)
                && areEqual(player, 0, 2)) {
            return true;
        }
        // if you made it here, then you've got no diagonals
        return false;
    }

    private boolean checkRows(char player) {
        for (int row = 0; row < this.gameBoard.length; row++) {
            if (areEqual(player, row, 0) && areEqual(player, row, 1) && areEqual(player, row, 2)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkCols(char player) {
        for (int col = 0; col < this.gameBoard.length; col++) {
            if (areEqual(player, 0, col) && areEqual(player, 1, col) && areEqual(player, 2, col)) {
                return true;
            }
        }
        return false;
    }

    private boolean areEqual(char player, int row, int col) {
        return this.gameBoard[row][col] == player;
    }
}
