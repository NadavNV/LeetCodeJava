import java.util.Arrays;
import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) return triangle.getFirst().getFirst();
        int[] prevRow = new int[triangle.size()];
        int[] nextRow = new int[triangle.size()];
        prevRow[0] = triangle.getFirst().getFirst();
        for (int i = 1; i < triangle.size(); i++) {
            nextRow = new int[triangle.size()];
            List<Integer> row = triangle.get(i);
            nextRow[0] = prevRow[0] + row.getFirst();
            nextRow[row.size() - 1] = prevRow[row.size() - 2] + row.getLast();
            for (int j = 1; j < row.size() - 1; j++) {
                nextRow[j] = Math.min(prevRow[j - 1], prevRow[j]) + row.get(j);
            }
            prevRow = nextRow;
        }
        int currentMin = Integer.MAX_VALUE;
        for (int num : nextRow) {
            currentMin = Math.min(currentMin, num);
        }
        return currentMin;
    }

    public static void main(String[] args) {
        Triangle sol = new Triangle();
        List<List<Integer>> test = List.of(
                List.of(2),
                List.of(3, 4),
                List.of(6, 5, 7),
                List.of(4, 1, 8, 3)
        );
        System.out.println(sol.minimumTotal(test) == 11);
        test = List.of(List.of(-10));
        System.out.println(sol.minimumTotal(test) == -10);
    }
}
