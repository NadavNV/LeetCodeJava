public class UniquePathsTwo {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // paths[i][j] = number of paths from 0, 0 to point i, j on the grid
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] paths = new int[m][n];
        paths[0][0] = 1 - obstacleGrid[0][0];
        for (int i = 1; i < n; i++) {
            paths[0][i] = (obstacleGrid[0][i] == 0) ? paths[0][i - 1] : 0;
        }
        for (int i = 1; i < m; i++) {
            paths[i][0] = (obstacleGrid[i][0] == 0) ? paths[i - 1][0] : 0;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                paths[i][j] = (obstacleGrid[i][j] == 0) ? paths[i - 1][j] + paths[i][j - 1] : 0;
            }
        }
        return paths[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePathsTwo sol = new UniquePathsTwo();
        int[][] test1 = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        int[][] test2 = {
                {0, 1},
                {0, 0}
        };
        System.out.println(sol.uniquePathsWithObstacles(test1) == 2);
        System.out.println(sol.uniquePathsWithObstacles(test2) == 1);
    }
}
