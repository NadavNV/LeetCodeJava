import java.util.Arrays;

public class LongestVShapedDiagonal {
    private static final int[][] DIRS = {{1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
    private int[][][][] memo;
    private int[][] grid;
    private int m, n;

    public int lenOfVDiagonal(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        this.memo = new int[m][n][4][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    Arrays.fill(memo[i][j][k], -1);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int direction = 0; direction < 4; direction++) {
                        result = Math.max(result, dfs(i, j, direction, true, 2) + 1);
                    }
                }
            }
        }
        return result;
    }

    private int dfs(int x, int y, int direction, boolean turn, int target) {
        int nextX = x + DIRS[direction][0];
        int nextY = y + DIRS[direction][1];
        if (
                nextX < 0 || nextY < 0 ||
                        nextX >= m || nextY >= n ||
                        grid[nextX][nextY] != target
        ) {
            return 0;
        }

        int turnInt = turn ? 1 : 0;
        if (memo[nextX][nextY][direction][turnInt] != -1) {
            return memo[nextX][nextY][direction][turnInt];
        }
        int maxStep = dfs(nextX, nextY, direction, turn, 2 - target);
        if (turn) {
            maxStep = Math.max(maxStep, dfs(nextX, nextY, (direction + 1) % 4, false, 2 - target));
        }
        memo[nextX][nextY][direction][turnInt] = maxStep + 1;
        return maxStep + 1;
    }

    public static void main(String[] args) {
        LongestVShapedDiagonal sol = new LongestVShapedDiagonal();
        int[][] test1 = {
                {2, 2, 1, 2, 2},
                {2, 0, 2, 2, 0},
                {2, 0, 1, 1, 0},
                {1, 0, 2, 2, 2},
                {2, 0, 0, 2, 2}
        };
        int[][] test2 = {
                {2, 2, 2, 2, 2},
                {2, 0, 2, 2, 0},
                {2, 0, 1, 1, 0},
                {1, 0, 2, 2, 2},
                {2, 0, 0, 2, 2}
        };
        int[][] test3 = {
                {1, 2, 2, 2, 2},
                {2, 2, 2, 2, 0},
                {2, 0, 0, 0, 0},
                {0, 0, 2, 2, 2},
                {2, 0, 0, 2, 0}
        };
        System.out.println(sol.lenOfVDiagonal(test1) == 5);
        System.out.println(sol.lenOfVDiagonal(test2) == 4);
        System.out.println(sol.lenOfVDiagonal(test3) == 5);
    }
}
