import java.util.Stack;

public class CountSubmatricesAllOnes {
    public int numSubmat(int[][] mat) {
        int n = mat[0].length;
        int[] heights = new int[n];
        int result = 0;
        for (int[] row : mat) {
            for (int i = 0; i < n; i++) {
                heights[i] = (row[i] == 0) ? 0 : heights[i] + 1;
            }
            Stack<int[]> stack = new Stack<>();
            stack.push(new int[]{-1, 0, -1});
            for (int i = 0; i < n; i++) {
                int height = heights[i];
                while (stack.peek()[2] >= height) {
                    stack.pop();
                }
                int[] top = stack.peek();
                int j = top[0];
                int previous = top[1];
                int current = previous + (i - j) * height;
                stack.push(new int[]{i, current, height});
                result += current;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CountSubmatricesAllOnes sol = new CountSubmatricesAllOnes();
        int[][] test1 = {
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}
        };
        int[][] test2 = {
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 1, 1, 0}
        };
        System.out.println(sol.numSubmat(test1) == 13);
        System.out.println(sol.numSubmat(test2) == 24);
    }
}
