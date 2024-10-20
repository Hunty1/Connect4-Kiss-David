public class Connect4 {
    private char[][] board;
    private int rows = 6;
    public static final int COLUMNS = 7;
    public static final int ROWS = 6;
    private char currentPlayer;

    public Connect4() {
        board = new char[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                board[i][j] = ' ';
            }
        }
        currentPlayer = 'X';
    }


    public char getCurrentPlayer() {
        return currentPlayer;
    }


    public void setCurrentPlayer(char player) {
        currentPlayer = player;
    }


    public char getBoardCell(int row, int column) {
        return board[row][column];
    }


    public void setBoardCell(int row, int column, char value) {
        board[row][column] = value;
    }

    public void printBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                System.out.print("| " + board[i][j] + " ");
            }
            System.out.println("|");
            System.out.println("-----------------------------");
        }
    }

    public boolean makeMove(int column, char player) {
        if (!isValidMove(column)) {
            return false;
        }
        for (int i = ROWS - 1; i >= 0; i--) {
            if (board[i][column] == ' ') {
                board[i][column] = player;
                return true;
            }
        }
        return false;
    }

    public boolean checkWin(char player) {
        return checkHorizontalWin(player) || checkVerticalWin(player) || checkDiagonalWin(player);
    }

    public boolean isBoardFull() {
        for (int j = 0; j < COLUMNS; j++) {
            if (board[0][j] == ' ') {
                return false;
            }
        }
        return true;
    }

    public boolean isValidMove(int column) {
        if (column < 0 || column >= COLUMNS) {
            return false;
        }
        return board[0][column] == ' ';
    }

    private boolean checkHorizontalWin(char player) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS - 3; j++) {
                if (board[i][j] == player && board[i][j + 1] == player &&
                        board[i][j + 2] == player && board[i][j + 3] == player) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkVerticalWin(char player) {
        for (int j = 0; j < COLUMNS; j++) {
            for (int i = 0; i < ROWS - 3; i++) {
                if (board[i][j] == player && board[i + 1][j] == player &&
                        board[i + 2][j] == player && board[i + 3][j] == player) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDiagonalWin(char player) {
        for (int i = 0; i < ROWS - 3; i++) {
            for (int j = 0; j < COLUMNS - 3; j++) {
                if (board[i][j] == player && board[i + 1][j + 1] == player &&
                        board[i + 2][j + 2] == player && board[i + 3][j + 3] == player) {
                    return true;
                }
            }
        }
        for (int i = 3; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS - 3; j++) {
                if (board[i][j] == player && board[i - 1][j + 1] == player &&
                        board[i - 2][j + 2] == player && board[i - 3][j + 3] == player) {
                    return true;
                }
            }
        }
        return false;
    }
}
