import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] result = new int[m * n];
        int row = 0, col = 0, i = 0;
        boolean ascend = true;
        do {
            result[i++] = mat[row][col];
            if (ascend) {
                if (row == 0) {
                    ascend = false;
                    if (col == n - 1) {
                        row++;
                    } else {
                        col++;
                    }
                } else if (col == n - 1) {
                    ascend = false;
                    // row != 0
                    row++;
                } else {
                    row--;
                    col++;
                }
            } else {
                if (col == 0) {
                    ascend = true;
                    if (row == m - 1) {
                        col++;
                    } else {
                        row++;
                    }
                } else if (row == m - 1) {
                    ascend = true;
                    // col != 0
                    col++;
                } else {
                    row++;
                    col--;
                }
            }
        } while (i < m * n);
        return result;
    }

    public static void main(String[] args) {
        DiagonalTraverse sol = new DiagonalTraverse();
        int[][] test1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] test2 = {
                {1, 2, 3},
                {4, 5, 6}
        };
        int[][] test3 = {
                {1, 2},
                {3, 4},
                {5, 6}
        };
        System.out.println(Arrays.equals(sol.findDiagonalOrder(test1), new int[]{1, 2, 4, 7, 5, 3, 6, 8, 9}));
        System.out.println(Arrays.equals(sol.findDiagonalOrder(test2), new int[]{1, 2, 4, 5, 3, 6}));
        System.out.println(Arrays.equals(sol.findDiagonalOrder(test3), new int[]{1, 2, 3, 5, 4, 6}));
    }
}
