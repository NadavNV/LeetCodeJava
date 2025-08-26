import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (target == 0) {
            result.add(new ArrayList<>(0));
            return result;
        }
        if (candidates.length > 0) {
            int i = 0;
            while (i * candidates[0] <= target) {
                List<Integer> partial = new ArrayList<>(i);
                for (int j = 0; j < i; j++) {
                    partial.add(candidates[0]);
                }
                List<List<Integer>> tempSolutions = combinationSum(
                        sliceArray(candidates, 1),
                        target - i * candidates[0]
                );
                for (List<Integer> tempSolution : tempSolutions) {
                    List<Integer> solution = new ArrayList<>();
                    solution.addAll(partial);
                    solution.addAll(tempSolution);
                    result.add(solution);
                }
                i++;
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
        CombinationSum sol = new CombinationSum();
        int[] test1 = {2, 3, 6, 7};
        int[] test2 = {2, 3, 5};
        int[] test3 = {2};
        System.out.println(sol.combinationSum(test1, 7));
        System.out.println(sol.combinationSum(test2, 8));
        System.out.println(sol.combinationSum(test3, 1));
    }
}
