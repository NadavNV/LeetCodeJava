import java.util.Arrays;

public class FirstAndLastPosition {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{findStart(nums, target, 0, nums.length - 1), findEnd(nums, target, 0, nums.length - 1)};
    }

    private int findStart(int[] nums, int target, int left, int right) {
        if (right < left) return -1;
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            if (mid == 0 || nums[mid] > nums[mid - 1]) {
                return mid;
            } else {
                return findStart(nums, target, left, mid - 1);
            }
        }
        if (nums[mid] > target) {
            return findStart(nums, target, left, mid - 1);
        } else {
            return findStart(nums, target, mid + 1, right);
        }
    }

    private int findEnd(int[] nums, int target, int left, int right) {
        if (right < left) return -1;
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            if (mid == nums.length - 1 || nums[mid] < nums[mid + 1]) {
                return mid;
            } else {
                return findEnd(nums, target, mid + 1, right);
            }
        }
        if (nums[mid] > target) {
            return findEnd(nums, target, left, mid - 1);
        } else {
            return findEnd(nums, target, mid + 1, right);
        }
    }

    public static void main(String[] args) {
        FirstAndLastPosition sol = new FirstAndLastPosition();
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.equals(sol.searchRange(nums, 8), new int[]{3, 4}));
        System.out.println(Arrays.equals(sol.searchRange(nums, 4), new int[]{-1, -1}));
        System.out.println(Arrays.equals(sol.searchRange(new int[0], 0), new int[]{-1, -1}));
    }
}
