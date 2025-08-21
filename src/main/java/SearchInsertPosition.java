public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int target, int left, int right) {
        if (right < left) return left;
        int mid = (left + right) / 2;
        if (nums[mid] == target) return mid;
        if (nums[mid] > target) {
            return binarySearch(nums, target, left, mid - 1);
        } else {
            return binarySearch(nums, target, mid + 1, right);
        }
    }

    public static void main(String[] args) {
        SearchInsertPosition sol = new SearchInsertPosition();
        int[] nums = new int[]{1, 3, 5, 6};
        System.out.println(sol.searchInsert(nums, 5) == 2);
        System.out.println(sol.searchInsert(nums, 2) == 1);
        System.out.println(sol.searchInsert(nums, 7) == 4);
        System.out.println(sol.searchInsert(nums, 0) == 0);
    }
}
