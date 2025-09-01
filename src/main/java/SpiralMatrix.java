import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        List<Integer> result = new ArrayList<>(m * n);
        int stepsHorizontal = m, stepsVertical = n;
        int dir = 0;
        int y = 0, x = -1;
        for (int added = 0; added < m * n; ) {
            int dy = DIRS[dir][0], dx = DIRS[dir][1];
            int steps = (dy == 0) ? stepsHorizontal : stepsVertical;
            for (int j = 0; j < steps; j++) {
                x += dx;
                y += dy;
                result.add(matrix[y][x]);
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
        SpiralMatrix sol = new SpiralMatrix();
        int[][] test1 = {
                {1, 2, 3},
                {8, 9, 4},
                {7, 6, 5}
        };
        int[][] test2 = {
                {1, 2, 3, 4},
                {10, 11, 12, 5},
                {9, 8, 7, 6}
        };
        System.out.println(sol.spiralOrder(test1));
        System.out.println(sol.spiralOrder(test2));
    }
}
