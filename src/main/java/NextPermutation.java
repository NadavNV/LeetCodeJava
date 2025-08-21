import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        // https://en.wikipedia.org/wiki/Permutation#Generation_in_lexicographic_order
        int k = -1;
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                k = i;
            }
        }
        if (k == -1) {
            Arrays.sort(nums);
            return;
        }
        int l = -1;
        for (int i = k + 1; i < n; i ++) {
            if (nums[k] < nums[i]) {
                l = i;
            }
        }
        int temp = nums[k];
        nums[k] = nums[l];
        nums[l] = temp;
        for (int i = 0; i < (n - k) / 2; i++) {
            temp = nums[k + 1 + i];
            nums[k + 1 + i] = nums[n - 1 - i];
            nums[n - 1 - i] = temp;
        }
    }

    public static void main(String[] args) {
        NextPermutation sol = new NextPermutation();
        int[] test1 = new int[]{1, 2, 3};
        int[] test2 = new int[]{3, 2, 1};
        int[] test3 = new int[]{1, 1, 5};
        sol.nextPermutation(test1);
        sol.nextPermutation(test2);
        sol.nextPermutation(test3);
        System.out.println(Arrays.equals(test1, new int[]{1, 3, 2}));
        System.out.println(Arrays.equals(test2, new int[]{1, 2, 3}));
        System.out.println(Arrays.equals(test3, new int[]{1, 5, 1}));
    }
}
