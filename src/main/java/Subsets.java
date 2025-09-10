import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int subsetSize = 0; subsetSize <= nums.length; subsetSize++) {
            backtrack(subsetSize, nums, 0, new ArrayList<>(), result);
        }
        return result;
    }

    private void backtrack(
            int subsetSize,
            int[] nums,
            int nextNum,
            List<Integer> currentSubset,
            List<List<Integer>> result
    ) {
        if (currentSubset.size() == subsetSize) {
            result.add(new ArrayList<>(currentSubset));
            return;
        }
        if (nextNum >= nums.length) {
            return;
        }
        currentSubset.add(nums[nextNum]);
        backtrack(subsetSize, nums, nextNum + 1, currentSubset, result);
        currentSubset.removeLast();
        backtrack(subsetSize, nums, nextNum + 1, currentSubset, result);
    }

    public static void main(String[] args) {
        Subsets sol = new Subsets();
        System.out.println(sol.subsets(new int[]{1, 2, 3}));
        System.out.println(sol.subsets(new int[]{0}));
    }
}
