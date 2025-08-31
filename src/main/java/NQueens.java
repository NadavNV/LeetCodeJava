import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        backtrack(0, board, results);
        return results;
    }

    private void backtrack(int nextRow, char[][] board, List<List<String>> results) {
        if (nextRow == board.length) {
            List<String> solution = new ArrayList<>();
            for (char[] row : board) {
                solution.add(new String(row));
            }
            results.add(solution);
            return;
        }

        for (int column = 0; column < board.length; column++) {
            if (isSafe(board, nextRow, column)) {
                board[nextRow][column] = 'Q';
                backtrack(nextRow + 1, board, results);
                board[nextRow][column] = '.';
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int column) {
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][column] == 'Q') {
                return false;
            }
        }
        int i = row - 1, j = column - 1;
        while (i >= 0 && j >= 0) {
            if (board[i--][j--] == 'Q') {
                return false;
            }
        }
        i = row - 1;
        j = column + 1;
        while (i >= 0 && j < board.length) {
            if (board[i--][j++] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NQueens sol = new NQueens();
        for (List<String> solution : sol.solveNQueens(4)) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
        System.out.println(sol.solveNQueens(1));
    }
}
