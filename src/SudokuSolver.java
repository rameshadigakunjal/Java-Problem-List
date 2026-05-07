import java.util.Arrays;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        // Fill existing values
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    int boxIndex = (i / 3) * 3 + (j / 3);
                    rows[i][num] = true;
                    cols[j][num] = true;
                    boxes[boxIndex][num] = true;
                }
            }
        }

        solve(board, rows, cols, boxes);
    }

    private boolean solve(char[][] board, boolean[][] rows,
                          boolean[][] cols, boolean[][] boxes) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    int boxIndex = (i / 3) * 3 + (j / 3);

                    for (int num = 0; num < 9; num++) {
                        if (!rows[i][num] && !cols[j][num] && !boxes[boxIndex][num]) {

                            board[i][j] = (char) (num + '1');
                            rows[i][num] = cols[j][num] = boxes[boxIndex][num] = true;

                            if (solve(board, rows, cols, boxes)) return true;

                            board[i][j] = '.';
                            rows[i][num] = cols[j][num] = boxes[boxIndex][num] = false;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        SudokuSolver app = new SudokuSolver();
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        app.solveSudoku(board);
        System.out.println("Solved Sudoku:");
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }
}
    

