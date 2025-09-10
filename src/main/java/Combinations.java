import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<Integer>(), result);
        return result;
    }

    private void backtrack(int nextNumber, int n, int k, List<Integer> currentCombination, List<List<Integer>> result) {
        if (k == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }
        if (nextNumber > n) {
            return;
        }
        currentCombination.add(nextNumber);
        backtrack(nextNumber + 1, n, k - 1, currentCombination, result);
        currentCombination.removeLast();
        backtrack(nextNumber + 1, n, k, currentCombination, result);
    }

    public static void main(String[] args) {
        Combinations sol = new Combinations();
        System.out.println(sol.combine(4, 2));
        System.out.println(sol.combine(1, 1));
    }
}
