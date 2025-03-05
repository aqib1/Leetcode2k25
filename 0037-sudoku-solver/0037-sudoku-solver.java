class Solution {
    private char[][] board;

    public void solveSudoku(char[][] board) {
        this.board = board;
        solve(0, 0);
    }

    public boolean solve(int row, int column) {
        if (column == Constants.BOARD_SIZE) {
            row++;
            if (row == Constants.BOARD_SIZE) {
                return true;
            } else {
                column = 0;
            }
        }

        if (board[row][column] != '.')
            return solve(row, column + 1);

        for (char num = Constants.MIN_NUMBER; num <= Constants.MAX_NUMBER; num++) {
            if (isValid(row, column, num)) {
                board[row][column] = num;
                if (solve(row, column + 1)) {
                    return true;
                }
                // backtrack
                board[row][column] = '.';
            }
        }
        return false;
    }

    public boolean isValid(int row, int column, char amount) {
        for (int i = 0; i < Constants.BOARD_SIZE; i++)
            if (board[i][column] == amount || board[row][i] == amount)
                return false;

        row = (row / Constants.BOX_SIZE) * Constants.BOX_SIZE;
        column = (column / Constants.BOX_SIZE) * Constants.BOX_SIZE;

        for (int r = row; r < row + Constants.BOX_SIZE; r++) {
            for (int c = column; c < column + Constants.BOX_SIZE; c++) {
                if (board[r][c] == amount)
                    return false;
            }
        }

        return true;
    }

    private void showSudoku() {
        for (int i = 0; i < Constants.BOARD_SIZE; i++) {
            if (i % Constants.BOX_SIZE == 0)
                System.out.println();
            for (int j = 0; j < Constants.BOARD_SIZE; j++) {
                if (j % Constants.BOX_SIZE == 0)
                    System.out.print("  ");
                System.out.print(board[i][j] + " ");
            }

            System.out.println();
        }
    }

    private static class Constants {
        private Constants() {

        }

        public static final int BOARD_SIZE = 9;
        public static final char MIN_NUMBER = '1';
        public static final char MAX_NUMBER = '9';
        public static final int BOX_SIZE = 3;
    }
}