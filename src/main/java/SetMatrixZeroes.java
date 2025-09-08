import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int flag = findFlagNum(matrix);
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col <matrix[row].length; col++) {
                if (matrix[row][col] == 0) {
                    for (int y = 0; y <matrix.length; y++) {
                        if (matrix[y][col] != 0) {
                            matrix[y][col] = flag;
                        }
                    }
                    for (int x = 0; x <matrix[row].length; x++) {
                        if (matrix[row][x] != 0) {
                            matrix[row][x] = flag;
                        }
                    }
                }
            }
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == flag) {
                    matrix[row][col] = 0;
                }
            }
        }
    }

    private static int findFlagNum(int[][] matrix) {
        // Put all numbers into a HashSet for fast lookup
        Set<Integer> seen = new HashSet<>();
        for (int[] row : matrix) {
            for (int x : row) {
                seen.add(x);
            }
        }

        // Look for the first integer not in the set
        // Start from Integer.MIN_VALUE and go upward
        for (long i = Integer.MIN_VALUE; i <= Integer.MAX_VALUE; i++) {
            if (!seen.contains((int) i)) {
                return (int) i;
            }
        }

        throw new IllegalStateException("Every integer exists in the matrix (impossible).");
    }

    public static void main(String[] args) {
        int[][] test1 = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        int[][] test2 = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        int[][] expected1 = {
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}
        };
        int[][] expected2 = {
                {0, 0, 0, 0},
                {0, 4, 5, 0},
                {0, 3, 1, 0}
        };
        SetMatrixZeroes sol = new SetMatrixZeroes();
        sol.setZeroes(test1);
        sol.setZeroes(test2);
        System.out.println(Arrays.deepEquals(test1, expected1));
        System.out.println(Arrays.deepEquals(test2, expected2));
    }
}
