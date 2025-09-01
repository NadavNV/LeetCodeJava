import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for (int[] interval : intervals) {
            if (result.isEmpty()) result.add(interval);
            else {
                int start = interval[0], end = interval[1];
                int[] previous = result.getLast();
                int prevStart = previous[0], prevEnd = previous[1];
                if (prevStart <= start && start <= prevEnd) {
                    // previous[0] = prevStart;
                    previous[1] = Math.max(end, prevEnd);
                } else {
                    result.add(interval);
                }
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        MergeIntervals sol = new MergeIntervals();
        int[][] test1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] expected1 = {{1, 6}, {8, 10}, {15, 18}};
        int[][] test2 = {{1, 4}, {4, 5}};
        int[][] expected2 = {{1, 5}};
        int[][] test3 = {{5, 6}, {1, 4}};
        int[][] expected3 = {{1, 4}, {5, 6}};
        int[][] test4 = {{0, 0}, {1, 4}};
        int[][] expected4 = {{0, 0}, {1, 4}};
        System.out.println(Arrays.deepEquals(sol.merge(test1), expected1));
        System.out.println(Arrays.deepEquals(sol.merge(test2), expected2));
        System.out.println(Arrays.deepEquals(sol.merge(test3), expected3));
        System.out.println(Arrays.deepEquals(sol.merge(test4), expected4));
    }
}
