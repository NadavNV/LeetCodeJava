import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class CountElementsWithMaximumFrequency {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        int maxFrequency = counter.values().stream().max(Comparator.naturalOrder()).orElseThrow();
        int result = 0;
        for (int freq : counter.values()) {
            if (freq == maxFrequency) {
                result += freq;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CountElementsWithMaximumFrequency sol = new CountElementsWithMaximumFrequency();
        int[][] test = {
                {1, 2, 2, 3, 1, 4},
                {1, 2, 3, 4, 5}
        };
        int[] expected = {4, 5};
        for (int i = 0; i < test.length; i++) {
            System.out.println(sol.maxFrequencyElements(test[i]) == expected[i]);
        }
    }
}
