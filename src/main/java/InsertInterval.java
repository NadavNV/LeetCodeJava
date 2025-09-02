import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length, i = 0;
        List<int[]> result = new ArrayList<>();

        // Intervals that don't overlap with the new one
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i++]);
        }

        // Overlapping intervals, need to merge them
        while (i < n && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        // Intervals that don't overlap with the new one
        while (i < n) {
            result.add(intervals[i++]);
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        InsertInterval sol = new InsertInterval();
        System.out.println(Arrays.deepEquals(
                sol.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5}),
                new int[][]{{1, 5}, {6, 9}}
        ));
        System.out.println(Arrays.deepEquals(
                sol.insert(
                        new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}},
                        new int[]{4, 8}
                ),
                new int[][]{{1, 2}, {3, 10}, {12, 16}}
        ));
    }
}
