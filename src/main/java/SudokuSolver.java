import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class SudokuSolver {
    private static final Set<Character> digits = Set.of('1', '2', '3', '4', '5', '6', '7', '8', '9');

    public void solveSudoku(char[][] board) {
        bfs(board);
    }

    private boolean bfs(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    Set<Character> available = getAvailableDigits(board, i, j);
                    if (available.isEmpty()) {
                        return false;
                    }
                    for (char digit : available) {
                        board[i][j] = digit;
                        if (bfs(board)) {
                            return true;
                        }
                    }
                    board[i][j] = '.';
                    return false;
                }
            }
        }
        return true;
    }

    private Set<Character> getAvailableDigits(char[][] board, int i, int j) {
        Set<Character> used = new HashSet<>();
        for (int k = 0; k < board.length; k++) {
            if (board[i][k] != '.') {
                used.add(board[i][k]);
            }
            if (board[k][j] != '.') {
                used.add(board[k][j]);
            }
        }
        int squareVertical = i / 3;
        int squareHorizontal = j / 3;
        for (int y = 3 * squareVertical; y < 3 * squareVertical + 3; y++) {
            for (int x = 3 * squareHorizontal; x < 3 * squareHorizontal + 3; x++) {
                if (board[y][x] != '.') {
                    used.add(board[y][x]);
                }
            }
        }
        return digits.stream().filter(c -> !used.contains(c)).collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        SudokuSolver sol = new SudokuSolver();
        char[][] board = {
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
        char[][] expected = {
                {'5', '3', '4', '6', '7', '8', '9', '1', '2'},
                {'6', '7', '2', '1', '9', '5', '3', '4', '8'},
                {'1', '9', '8', '3', '4', '2', '5', '6', '7'},
                {'8', '5', '9', '7', '6', '1', '4', '2', '3'},
                {'4', '2', '6', '8', '5', '3', '7', '9', '1'},
                {'7', '1', '3', '9', '2', '4', '8', '5', '6'},
                {'9', '6', '1', '5', '3', '7', '2', '8', '4'},
                {'2', '8', '7', '4', '1', '9', '6', '3', '5'},
                {'3', '4', '5', '2', '8', '6', '1', '7', '9'}
        };
        sol.solveSudoku(board);
        System.out.println(Arrays.deepEquals(board, expected));
    }
}
