import java.util.Arrays;

public class SortColors {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[mid];
                nums[mid++] = nums[low];
                nums[low++] = temp;
            } else if (nums[mid] == 2) {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high--] = temp;
            } else {
                mid++;
            }
        }
    }

    public static void main(String[] args) {
        SortColors sol = new SortColors();
        int[][] test = {
                {2, 0, 2, 1, 1, 0},
                {2, 0, 1}
        };
        int[][] expected = {
                {0, 0, 1, 1, 2, 2},
                {0, 1, 2}
        };
        for (int i = 0; i < test.length; i++) {
            sol.sortColors(test[i]);
            System.out.println(Arrays.equals(test[i], expected[i]));
        }
    }
}
