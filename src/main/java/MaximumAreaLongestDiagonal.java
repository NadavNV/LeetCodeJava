public class MaximumAreaLongestDiagonal {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxDiagonal = Integer.MIN_VALUE, maxArea = Integer.MIN_VALUE;
        for (int[] rect : dimensions) {
            int length = rect[0], width = rect[1];
            int diagonal = length * length + width * width;
            if (diagonal > maxDiagonal) {
                maxDiagonal = diagonal;
                maxArea = width * length;
            } else if (diagonal == maxDiagonal) {
                maxArea = Math.max(maxArea, length * width);
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        MaximumAreaLongestDiagonal sol = new MaximumAreaLongestDiagonal();
        int[][] test1 = {{9, 3}, {8, 6}};
        int[][] test2 = {{4, 3}, {3, 4}};
        System.out.println(sol.areaOfMaxDiagonal(test1) == 48);
        System.out.println(sol.areaOfMaxDiagonal(test2) == 12);
    }
}
