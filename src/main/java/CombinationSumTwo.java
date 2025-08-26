import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CombinationSumTwo {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int num : candidates) {
            if (frequencies.containsKey(num)) {
                frequencies.put(num, frequencies.get(num) + 1);
            } else {
                frequencies.put(num, 1);
            }
        }
        List<int[]> counter = new ArrayList<>();
        for (Map.Entry<Integer, Integer> freq : frequencies.entrySet()) {
            counter.add(new int[]{freq.getKey(), freq.getValue()});
        }
        backtrack(new ArrayList<>(), target, counter, 0, result);
        return result;
    }

    private void backtrack(
            List<Integer> partialSolution,
            int remaining,
            List<int[]> counter,
            int currentCandidate,
            List<List<Integer>> result
    ) {
        if (remaining == 0) {
            // Found a solution, make a deep copy of it
            List<Integer> solution = new ArrayList<>(partialSolution);
            result.add(solution);
            return;
        } else if (remaining < 0) {
            // Invalid partial solution
            return;
        }
        for (int nextCandidate = currentCandidate; nextCandidate < counter.size(); nextCandidate++) {
            int candidate = counter.get(nextCandidate)[0], frequency = counter.get(nextCandidate)[1];
            if (frequency <= 0) {
                continue;
            }
            // Add current candidate to the current solution
            partialSolution.add(candidate);
            counter.get(nextCandidate)[1]--;
            // Keep searching with the updated solution
            backtrack(partialSolution, remaining - candidate, counter, nextCandidate, result);
            // Undo the changes and try another candidate
            counter.get(nextCandidate)[1]++;
            partialSolution.removeLast();
        }
    }

    public static void main(String[] args) {
        CombinationSumTwo sol = new CombinationSumTwo();
        int[] test1 = {10, 1, 2, 7, 6, 1, 5};
        int[] test2 = {2, 5, 2, 1, 2};
        System.out.println(sol.combinationSum2(test1, 8));
        System.out.println(sol.combinationSum2(test2, 5));
    }
}
