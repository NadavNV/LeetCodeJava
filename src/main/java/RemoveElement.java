import java.util.Arrays;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    public static void main(String[] args) {
        RemoveElement sol = new RemoveElement();
        int[] nums = new int[]{3, 2, 2, 3};
        System.out.println(sol.removeElement(nums, 3) == 2);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(sol.removeElement(nums, 2) == 5);
        System.out.println(Arrays.toString(nums));
        nums = new int[0];
        System.out.println(sol.removeElement(nums, 5) == 0);
        nums = new int[]{5};
        System.out.println(sol.removeElement(nums, 5) == 0);
    }
}
