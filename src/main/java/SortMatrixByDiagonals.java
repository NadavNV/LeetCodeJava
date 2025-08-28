import java.util.*;

public class SortMatrixByDiagonals {
    public int[][] sortMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] result = new int[m][n];
        // Bottom left triangle
        for (int start = 0; start < m; start++) {
            List<Integer> diag = new ArrayList<>();
            int y = start, x = 0;
            while (y < m && x < n) {
                diag.add(grid[y++][x++]);
            }
            diag.sort(Comparator.reverseOrder());
            y = start;
            x = 0;
            for (int num : diag) {
                result[y++][x++] = num;
            }
        }
        // Top right triangle
        for (int start = 1; start < n; start++) {
            List<Integer> diag = new ArrayList<>();
            int y = 0, x = start;
            while (y < m && x < n) {
                diag.add(grid[y++][x++]);
            }
            diag.sort(Comparator.naturalOrder());
            y = 0;
            x = start;
            for (int num : diag) {
                result[y++][x++] = num;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SortMatrixByDiagonals sol = new SortMatrixByDiagonals();
        int[][] test1 = {
                {1, 7, 3},
                {9, 8, 2},
                {4, 5, 6}
        };
        int[][] expected1 = {
                {8, 2, 3},
                {9, 6, 7},
                {4, 5, 1}
        };
        int[][] test2 = {
                {0, 1},
                {1, 2}
        };
        int[][] expected2 = {
                {2, 1},
                {1, 0}
        };
        System.out.println(Arrays.deepEquals(sol.sortMatrix(test1), expected1));
        System.out.println(Arrays.deepEquals(sol.sortMatrix(test2), expected2));
    }
}
