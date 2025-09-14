import java.util.Stack;

public class LargestRectangleHistogram {
    public int largestRectangleArea(int[] heights) {
        int best = 0;
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            // The new starting index for the height with height h. Defaults to its original index.
            int index = i;
            //Pop the previous item from stack if its height is greater than the current height.
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] tuple = stack.pop();
                int height = tuple[1];
                index = tuple[0];
                // Compare the current best with the area that can be achieved by extending the
                // previous item's height because it can no longer extend further.
                best = Math.max(best, (i - index) * height);
            }

            stack.add(new int[]{index, heights[i]});
        }
        // An item will remain in the stack if a smaller height hasn't been encountered.
        // Area for this item can be calculated from its index to the end of the array.
        for (int[] tuple : stack) {
            best = Math.max(best, (heights.length - tuple[0]) * tuple[1]);
        }
        return best;
    }

    public static void main(String[] args) {
        LargestRectangleHistogram sol = new LargestRectangleHistogram();
        System.out.println(sol.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}) == 10);
        System.out.println(sol.largestRectangleArea(new int[]{2, 4}) == 4);
    }
}
