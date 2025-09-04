import java.util.Arrays;

public class NumberOfWaysToPlacePeopleTwo {
    public int numberOfPairs(int[][] points) {
        int result = 0;
        Arrays.sort(points, (a, b) -> (a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]));
        for (int i = 0; i < points.length - 1; i++) {
            int[] pointA = points[i];
            int xMin = pointA[0] - 1;
            int xMax = Integer.MAX_VALUE;
            int yMin = Integer.MIN_VALUE;
            int yMax = pointA[1] + 1;

            for (int j = i + 1; j < points.length; j++) {
                if (
                        points[j][0] > xMin &&
                                points[j][0] < xMax &&
                                points[j][1] > yMin &&
                                points[j][1] < yMax
                ) {
                    result++;
                    xMin = points[j][0];
                    yMin = points[j][1];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        NumberOfWaysToPlacePeopleTwo sol = new NumberOfWaysToPlacePeopleTwo();
        int[][] test1 = {{1, 1}, {2, 2}, {3, 3}};
        int[][] test2 = {{6, 2}, {4, 4}, {2, 6}};
        int[][] test3 = {{3, 1}, {1, 3}, {1, 1}};
        System.out.println(sol.numberOfPairs(test1) == 0);
        System.out.println(sol.numberOfPairs(test2) == 2);
        System.out.println(sol.numberOfPairs(test3) == 2);
    }
}
