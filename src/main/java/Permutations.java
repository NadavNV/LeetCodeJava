import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> permutation = Arrays.stream(nums).boxed().collect(Collectors.toCollection(ArrayList::new));
        while (!permutation.isEmpty()) {
            result.add(new ArrayList<>(permutation));
            nextPermutation(permutation);
        }
        return result;
    }

    private void nextPermutation(List<Integer> prev) {
        int k = -1;
        int n = prev.size();
        for (int i = 0; i < n - 1; i++) {
            if (prev.get(i) < prev.get(i + 1)) {
                k = i;
            }
        }
        if (k == -1) {
            prev.clear();
            return;
        }
        int l = k + 1;
        for (int i = k + 1; i < n; i++) {
            if (prev.get(i) > prev.get(k)) {
                l = i;
            }
        }
        swap(prev, l, k);
        for (int i = 0; i < (n - k) / 2; i++) {
            swap(prev, k + 1 + i, n - 1 - i);
        }
    }

    private void swap(List<Integer> list, int a, int b) {
        int temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
    }

    public static void main(String[] args) {
        Permutations sol = new Permutations();
        int[] test1 = {1, 2, 3};
        List<List<Integer>> expected1 = new ArrayList<>(6);
        expected1.add(List.of(1, 2, 3));
        expected1.add(List.of(1, 3, 2));
        expected1.add(List.of(2, 1, 3));
        expected1.add(List.of(2, 3, 1));
        expected1.add(List.of(3, 1, 2));
        expected1.add(List.of(3, 2, 1));
        int[] test2 = {0, 1};
        List<List<Integer>> expected2 = new ArrayList<>(2);
        expected2.add(List.of(0, 1));
        expected2.add(List.of(1, 0));
        System.out.println(sol.permute(test1).equals(expected1));
        System.out.println(sol.permute(test2).equals(expected2));
    }
}
