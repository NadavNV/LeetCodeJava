import java.util.Arrays;

public class SpiralMatrixTwo {
    private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int stepsVertical = n, stepsHorizontal = n;
        int i = 1, dir = 0;
        int y = 0, x = -1;
        for (int added = 0; added < n * n; ) {
            int dy = DIRS[dir][0], dx = DIRS[dir][1];
            int steps = (dy == 0) ? stepsHorizontal : stepsVertical;
            for (int j = 0; j < steps; j++) {
                x += dx;
                y += dy;
                result[y][x] = i++;
            }
            added += steps;
            dir = (dir + 1) % 4;
            switch (dir) {
                case 0, 2 -> stepsHorizontal--;
                case 1, 3 -> stepsVertical--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SpiralMatrixTwo sol = new SpiralMatrixTwo();
        int[][] expected3 = {
                {1, 2, 3},
                {8, 9, 4},
                {7, 6, 5}
        };
        int[][] expected1 = {{1}};
        System.out.println(Arrays.deepEquals(sol.generateMatrix(3), expected3));
        System.out.println(Arrays.deepEquals(sol.generateMatrix(1), expected1));
    }
}
