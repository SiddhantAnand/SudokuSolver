public class Solve {

    private static int GRID_SIZE = 9;

    public boolean solve(int[][] board) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int column = 0; column < GRID_SIZE; column++) {
                if (board[row][column] == 0) {
                    for (int i = 1; i <= GRID_SIZE; i++) {
                        if (isValidPlacement(board, i, row, column)) {
                            board[row][column] = i;
                            if (solve(board)) {
                                return true;
                            } else {
                                board[row][column] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValueInRow(int[][] board, int number, int row) {
        for (int i = 0; i < GRID_SIZE; i++) {
            if (board[row][i] == number) {
                return true;
            }
        }
        return false;
    }

    private boolean isValueInColumn(int[][] board, int number, int column) {
        for (int i = 0; i < GRID_SIZE; i++) {
            if (board[i][column] == number) {
                return true;
            }
        }
        return false;
    }

    private boolean isValueInBox(int[][] board, int number, int row, int column) {
        int localRowHead = row - row % 3;
        int localColumnHead = column - column % 3;
        for (int i = localRowHead; i < localRowHead + 3; i++) {
            for (int j = localColumnHead; j < localColumnHead + 3; j++) {
                if (board[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValidPlacement(int[][] board, int number, int row, int column) {
        return (!isValueInRow(board, number, row) && !isValueInColumn(board, number, column)
                && !isValueInBox(board, number, row, column));
    }

    public void printSudoku(int[][] board) {
        for (int i = 0; i < GRID_SIZE; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("---------------------");
            }
            for (int j = 0; j < GRID_SIZE; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("| ");
                }
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

}
