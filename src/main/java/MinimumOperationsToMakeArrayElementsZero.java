import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumOperationsToMakeArrayElementsZero {
    public long minOperations(int[][] queries) {
        long steps = 0;
        for (int[] query : queries) {
            long count1 = count(query[1]);
            long count2 = count(query[0] - 1);
            steps += (count1 - count2 + 1) / 2;
        }
        return steps;
    }

    private long count(int num) {
        long result = 0;
        int i = 1;
        int base = 1;
        while (base <= num) {
            int end = Math.min(base * 2 - 1 , num);
            int costPerNumber = (i + 1) / 2;
            int numbersInRange = (end - base + 1);
            result += (long) costPerNumber * numbersInRange;
            i++;
            base *= 2;
        }
        return result;
    }

    public static void main(String[] args) {
        MinimumOperationsToMakeArrayElementsZero sol = new MinimumOperationsToMakeArrayElementsZero();
        int[][] test1 = {{1, 2}, {2, 4}};
        int[][] test2 = {{2, 6}};
        System.out.println(sol.minOperations(test1) == 3);
        System.out.println(sol.minOperations(test2) == 4);
    }
}
