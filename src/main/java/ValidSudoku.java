import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (!isValidRow(board, i)) return false;
            if (!isValidColumn(board, i)) return false;
        }
        for (int x = 0; x < board.length; x += 3) {
            for (int y = 0; y < board.length; y += 3) {
                if (!isValidSquare(board, x, y)) return false;
            }
        }
        return true;
    }

    private boolean isValidRow(char[][] board, int row) {
        Set<Character> usedDigits = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] != '.' && usedDigits.contains(board[row][i])) {
                return false;
            } else {
                usedDigits.add(board[row][i]);
            }
        }
        return true;
    }

    private boolean isValidColumn(char[][] board, int column) {
        Set<Character> usedDigits = new HashSet<>();
        for (char[] chars : board) {
            if (chars[column] != '.' && usedDigits.contains(chars[column])) {
                return false;
            } else {
                usedDigits.add(chars[column]);
            }
        }
        return true;
    }

    private boolean isValidSquare(char[][] board, int x, int y) {
        Set<Character> usedDigits = new HashSet<>();
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (board[i][j] != '.' && usedDigits.contains(board[i][j])) {
                    return false;
                } else {
                    usedDigits.add(board[i][j]);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidSudoku sol = new ValidSudoku();
        char[][] test1 = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        char[][] test2 = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(sol.isValidSudoku(test1));
        System.out.println(!sol.isValidSudoku(test2));
    }
}
