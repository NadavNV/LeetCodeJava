import java.util.Arrays;

public class RemoveDuplicatesTwo {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int j = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[j - 2]) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    public static void main(String[] args) {
        RemoveDuplicatesTwo sol = new RemoveDuplicatesTwo();
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println(sol.removeDuplicates(nums) == 5);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(sol.removeDuplicates(nums) == 7);
        System.out.println(Arrays.toString(nums));
    }
}
