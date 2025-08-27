public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            int value = Math.abs(nums[i]);
            if (value == n) {
                nums[0] = -Math.abs(nums[0]);
            } else if (value >= 1 && value <= n) {
                nums[value] = -Math.abs(nums[value]);
            }
        }
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }
        if (nums[0] > 0) {
            return n;
        }
        return n + 1;
    }

    public static void main(String[] args) {
        FirstMissingPositive sol = new FirstMissingPositive();
        int[] test1 = {1, 2, 0};
        int[] test2 = {3, 4, -1, 1};
        int[] test3 = {7, 8, 9, 11, 12};
        System.out.println(sol.firstMissingPositive(test1) == 3);
        System.out.println(sol.firstMissingPositive(test2) == 2);
        System.out.println(sol.firstMissingPositive(test3) == 1);
    }
}
