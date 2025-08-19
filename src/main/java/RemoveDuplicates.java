import java.util.Arrays;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    public static void main(String[] args) {
        RemoveDuplicates sol = new RemoveDuplicates();
        int[] nums = new int[]{1, 1, 2};
        System.out.println(sol.removeDuplicates(nums) == 2);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(sol.removeDuplicates(nums) == 5);
        System.out.println(Arrays.toString(nums));
    }
}
