import java.util.*;

public class ValidSudoco {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                char num = board[i][j];
                if (num == '.') continue;

                String row = num + " in row " + i;
                String col = num + " in col " + j;
                String box = num + " in box " + (i/3) + "-" + (j/3);

                if (!seen.add(row) || !seen.add(col) || !seen.add(box)) {
                    return false;
                }
            }
        }

        return true;
    }
    public static void main(String[] args) {
        ValidSudoco app = new ValidSudoco();
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
        boolean result = app.isValidSudoku(board);
        System.out.println("Is valid Sudoku: " + result);
    }
}