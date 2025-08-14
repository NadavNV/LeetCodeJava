import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 4);
    }

    private List<List<Integer>> kSum(int[] nums, long target, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        // There are k remaining values to add to the sum. The average
        // of these values is at least target / k.
        long averageValue = target / k;

        // We cannot obtain a sum of target if the smallest value
        // in nums is greater than target / k or if the largest
        // value in nums is smaller than target / k.
        if (averageValue < nums[0] || nums[nums.length - 1] < averageValue) {
            return result;
        }

        if (k == 2) {
            return twoSum(nums, target);
        }

        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                for (List<Integer> subset : kSum(sliceArray(nums, i + 1), target - nums[i], k - 1)) {
                    List<Integer> tuple = new ArrayList<>();
                    tuple.add(nums[i]);
                    tuple.addAll(subset);
                    result.add(tuple);
                }
            }
        }
        return result;
    }

    private List<List<Integer>> twoSum(int[] nums, long target) {
        List<List<Integer>> result = new ArrayList<>();
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int current = nums[left] + nums[right];
            if (current > target || (right < nums.length - 1 && nums[right] == nums[right + 1])) {
                right--;
            } else if (current < target || (left > 0 && nums[left] == nums[left - 1])) {
                left++;
            } else {
                result.add(List.of(nums[left], nums[right]));
                right--;
                left++;
            }
        }
        return result;
    }

    private int[] sliceArray(int[] array, int startIndex) {
        return Arrays.stream(array)
                .skip(startIndex)
                .toArray();
    }

    public static void main(String[] args) {
        FourSum test = new FourSum();
        System.out.println(test.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        System.out.println(test.fourSum(new int[]{2, 2, 2, 2, 2}, 8));
        System.out.println(test.fourSum(
                new int[]{-1000000000, -1000000000, 1000000000, -1000000000, -1000000000},
                294967296)
        );
    }
}
