public class MinimumAreaToCoverAllOnes {
    public int minimumArea(int[][] grid) {
        int minRow = Integer.MAX_VALUE, maxRow = Integer.MIN_VALUE, minCol = Integer.MAX_VALUE, maxCol = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    minRow = Math.min(minRow, i);
                    minCol = Math.min(minCol, j);
                    maxRow = Math.max(maxRow, i);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }
        return (maxRow - minRow + 1) * (maxCol - minCol + 1);
    }

    public static void main(String[] args) {
        MinimumAreaToCoverAllOnes sol = new MinimumAreaToCoverAllOnes();
        int[][] test1 = {
                {0, 1, 0},
                {1, 0, 1}
        };
        int[][] test2 = {
                {1, 0},
                {0, 0}
        };
        System.out.println(sol.minimumArea(test1) == 6);
        System.out.println(sol.minimumArea(test2) == 1);
    }
}
