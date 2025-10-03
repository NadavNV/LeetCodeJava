import java.util.Comparator;
import java.util.PriorityQueue;

public class TrappingRainWaterTwo {
    private record Cell(int height, int row, int column) {
    }

    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length, n = heightMap[0].length;

        // Initialization
        // Border cells cannot trap water
        if (m < 3 || n < 3) return 0;

        PriorityQueue<Cell> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a.height));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    heap.add(new Cell(heightMap[i][j], i, j));
                    // Mark as visited
                    heightMap[i][j] = -1;
                }
            }
        }
        int level = 0, result = 0;
        while (!heap.isEmpty()) {
            Cell current = heap.poll();
            level = Math.max(current.height, level);
            int[][] neighbors = {
                    {current.row - 1, current.column},
                    {current.row + 1, current.column},
                    {current.row, current.column - 1},
                    {current.row, current.column + 1}
            };
            for (int[] cell : neighbors) {
                int i = cell[0], j = cell[1];
                if (0 <= i && i < m && 0 <= j && j < n && heightMap[i][j] != -1) {
                    heap.add(new Cell(heightMap[i][j], i, j));
                    // If cell's height is lower than the current level it can trap rain water
                    if (heightMap[i][j] < level) {
                        result += level - heightMap[i][j];
                    }
                    heightMap[i][j] = -1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TrappingRainWaterTwo sol = new TrappingRainWaterTwo();
        int[][] test1 = {
                {1, 4, 3, 1, 3, 2},
                {3, 2, 1, 3, 2, 4},
                {2, 3, 3, 2, 3, 1}
        };
        int expected1 = 4;
        int[][] test2 = {
                {3, 3, 3, 3, 3},
                {3, 2, 2, 2, 3},
                {3, 2, 1, 2, 3},
                {3, 2, 2, 2, 3},
                {3, 3, 3, 3, 3}
        };
        int expected2 = 10;
        System.out.println(sol.trapRainWater(test1) == expected1);
        System.out.println(sol.trapRainWater(test2) == expected2);
    }
}
