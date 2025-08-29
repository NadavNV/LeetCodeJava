import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermutationsTwo {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            if (counter.containsKey(num)) {
                counter.put(num, counter.get(num) + 1);
            } else {
                counter.put(num, 1);
            }
        }
        findAllPermutations(new ArrayList<>(), result, counter, nums.length);
        return result;
    }

    private void findAllPermutations(
            List<Integer> permutation,
            List<List<Integer>> result,
            Map<Integer, Integer> counter,
            int length
    ) {
        if (permutation.size() == length) {
            result.add(new ArrayList<>(permutation));
            return;
        }
        for (int key : counter.keySet()) {
            if (counter.get(key) != 0) {
                counter.put(key, counter.get(key) - 1);
                List<Integer> nextPermutation = new ArrayList<>(permutation);
                nextPermutation.add(key);
                findAllPermutations(nextPermutation, result, counter, length);
                counter.put(key, counter.get(key) + 1);
            }
        }
    }

    public static void main(String[] args) {
        PermutationsTwo sol = new PermutationsTwo();
        int[] test2 = {1, 1, 2};
        List<List<Integer>> expected2 = new ArrayList<>(3);
        expected2.add(List.of(1, 1, 2));
        expected2.add(List.of(1, 2, 1));
        expected2.add(List.of(2, 1, 1));
        int[] test1 = {1, 2, 3};
        List<List<Integer>> expected1 = new ArrayList<>(6);
        expected1.add(List.of(1, 2, 3));
        expected1.add(List.of(1, 3, 2));
        expected1.add(List.of(2, 1, 3));
        expected1.add(List.of(2, 3, 1));
        expected1.add(List.of(3, 1, 2));
        expected1.add(List.of(3, 2, 1));
        System.out.println(sol.permuteUnique(test1).equals(expected1));
        System.out.println(sol.permuteUnique(test2).equals(expected2));
    }
}
