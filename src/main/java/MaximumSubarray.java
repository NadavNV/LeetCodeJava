public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int bestSum = Integer.MIN_VALUE, currentSum = 0;

        for (int num : nums) {
            currentSum += num;

            bestSum = Math.max(bestSum, currentSum);

            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return bestSum;
    }

    public static void main(String[] args) {
        MaximumSubarray sol = new MaximumSubarray();
        System.out.println(sol.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}) == 6);
        System.out.println(sol.maxSubArray(new int[]{1}) == 1);
        System.out.println(sol.maxSubArray(new int[]{5, 4, -1, 7, 8}) == 23);
    }
}
