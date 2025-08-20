public class CountSquareSubmatricesWithAllOnes {
    public int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        // dp[j] is the size of the largest square submatrix ending in column j of the current row
        int[] dp = new int[n + 1];
        // The value of dp[j - 1] in the previous row - the top-left neighbor
        int prev = 0;
        int answer = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == 1) {
                    int temp = dp[j];
                    // dp[j] = top neighbor
                    // dp[j-1] = left neighbor
                    // prev = top-left neighbor
                    dp[j] = 1 + Math.min(prev, Math.min(dp[j], dp[j - 1]));
                    prev = temp;
                    answer += dp[j];
                } else {
                    dp[j] = 0;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        CountSquareSubmatricesWithAllOnes sol = new CountSquareSubmatricesWithAllOnes();
        int[][] matrix1 = {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        };
        int[][] matrix2 = {
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}
        };
        System.out.println(sol.countSquares(matrix1) == 15);
        System.out.println(sol.countSquares(matrix2) == 7);
    }
}
