public class SearchRotatedArray {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int target, int left, int right) {
        if (right < left) return -1;
        int mid = (left + right) / 2;
        if (nums[mid] == target) return mid;
        if (nums[left] <= nums[mid]) {
            // left half is sorted
            if (nums[left] <= target && target < nums[mid]) {
                // target is in the left half
                return binarySearch(nums, target, left, mid - 1);
            } else {
                return binarySearch(nums, target, mid + 1, right);
            }
        } else {
            // right half is sorted
            if (nums[mid] < target && target <= nums[right]) {
                // target is in the right half
                return binarySearch(nums, target, mid + 1, right);
            } else {
                return binarySearch(nums, target, left, mid - 1);
            }
        }
    }

    public static void main(String[] args) {
        SearchRotatedArray sol = new SearchRotatedArray();
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(sol.search(nums, 0) == 4);
        System.out.println(sol.search(nums, 3) == -1);
    }
}
