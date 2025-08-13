import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        // Can also be done with sorting and binary search
        Set<List<Integer>> result = new HashSet<>();
        int numOfZeroes = 0;
        List<Integer> positives = new ArrayList<>(), negatives = new ArrayList<>();
        for (int num : nums) {
            if (num == 0) {
                numOfZeroes++;
            } else if (num > 0) {
                positives.add(num);
            } else {
                negatives.add(num);
            }
        }
        Set<Integer> positiveSet = new HashSet<>(positives), negativeSet = new HashSet<>(negatives);
        if (numOfZeroes >= 3) {
            result.add(List.of(0, 0, 0));
        }
        if (numOfZeroes > 0) {
            for (int num : positiveSet) {
                if (negativeSet.contains(-num)) {
                    result.add(List.of(-num, 0, num));
                }
            }
        }
        // Two negatives and a positive
        for (int i = 0; i < negatives.size(); i++) {
            for (int j = i + 1; j < negatives.size(); j++) {
                int target = -(negatives.get(i) + negatives.get(j));
                if (positiveSet.contains(target)) {
                    List<Integer> newTrio = new ArrayList<>(List.of(target, negatives.get(i), negatives.get(j)))
                            .stream()
                            .sorted()
                            .toList();
                    result.add(newTrio);
                }
            }
        }
        // Two positives and a negative
        for (int i = 0; i < positives.size(); i++) {
            for (int j = i + 1; j < positives.size(); j++) {
                int target = -(positives.get(i) + positives.get(j));
                if (negativeSet.contains(target)) {
                    List<Integer> newTrio = new ArrayList<>(List.of(target, positives.get(i), positives.get(j)))
                            .stream()
                            .sorted()
                            .toList();
                    result.add(newTrio);
                }
            }
        }
        return result.stream().toList();
    }

    public static void main(String[] args) {
        ThreeSum test = new ThreeSum();
        System.out.println(Objects.equals(
                test.threeSum(new int[]{-1, 0, 1, 2, -1, -4}),
                List.of(List.of(-1, -1, 2), List.of(-1, 0, 1))
        ) || Objects.equals(
                test.threeSum(new int[]{-1, 0, 1, 2, -1, -4}),
                List.of(List.of(-1, 0, 1), List.of(-1, -1, 2))
        ));
        System.out.println(test.threeSum(new int[]{0, 1, 1}).isEmpty());
        System.out.println(Objects.equals(test.threeSum(new int[]{0, 0, 0}), List.of(List.of(0, 0, 0))));
    }
}
