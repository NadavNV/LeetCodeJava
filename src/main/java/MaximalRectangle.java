import java.util.Stack;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null) return 0;
        int rows = matrix.length, cols = matrix[0].length;
        int best = 0;
        int[] heights = new int[cols + 1];
        for (char[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                heights[i] = row[i] == '1' ? heights[i] + 1 : 0;
            }
            Stack<Integer> monoStack = new Stack<>();
            for (int i = 0; i < heights.length; i++) {
                while (!monoStack.isEmpty() && heights[i] < heights[monoStack.peek()]) {
                    int height = heights[monoStack.pop()];
                    int width = monoStack.isEmpty() ? i : i - monoStack.peek() - 1;
                    best = Math.max(best, width * height);
                }
                monoStack.add(i);
            }
        }
        return best;
    }

    public static void main(String[] args) {
        MaximalRectangle sol = new MaximalRectangle();
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(sol.maximalRectangle(matrix) == 6);
    }
}
