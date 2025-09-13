public class SearchRotatedArrayTwo {
    public boolean search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) return true;

            if (nums[low] == nums[mid]) {
                low++;
                continue;
            }
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchRotatedArrayTwo sol = new SearchRotatedArrayTwo();
        System.out.println(sol.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));
        System.out.println(!sol.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3));
        System.out.println(sol.search(new int[]{1, 0, 1, 1, 1}, 0));
    }
}
