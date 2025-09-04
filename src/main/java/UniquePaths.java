public class UniquePaths {
    public int uniquePaths(int m, int n) {
        // paths[i][j] = number of paths from point i, j on the grid
        int[][] paths = new int[m][n];
        for (int i = 0; i < m; i++) {
            paths[i][n - 1] = 1;
        }
        for (int i = 0; i < n; i++) {
            paths[m - 1][i] = 1;
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                paths[i][j] = paths[i + 1][j] + paths[i][j + 1];
            }
        }
        return paths[0][0];
    }

    public static void main(String[] args) {
        UniquePaths sol = new UniquePaths();
        System.out.println(sol.uniquePaths(3, 7) == 28);
        System.out.println(sol.uniquePaths(3, 2) == 3);
        System.out.println(sol.uniquePaths(23, 12) == 193536720);
    }
}
