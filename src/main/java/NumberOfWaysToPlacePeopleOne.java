public class NumberOfWaysToPlacePeopleOne {
    public int numberOfPairs(int[][] points) {
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    if (points[i][0] <= points[j][0] && points[i][1] >= points[j][1]) {
                        if (isValidPair(points, i, j)) result++;
                    }
                }
            }
        }
        return result;
    }

    private boolean isValidPair(int[][] points, int topLeft, int bottomRight) {
        for (int i = 0; i < points.length; i++) {
            if (i == topLeft || i == bottomRight) continue;
            if ((points[i][0] >= points[topLeft][0] && points[i][0] <= points[bottomRight][0]) &&
                    (points[i][1] >= points[bottomRight][1] && points[i][1] <= points[topLeft][1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NumberOfWaysToPlacePeopleOne sol = new NumberOfWaysToPlacePeopleOne();
        int[][] test1 = {{1, 1}, {2, 2}, {3, 3}};
        int[][] test2 = {{6, 2}, {4, 4}, {2, 6}};
        int[][] test3 = {{3, 1}, {1, 3}, {1, 1}};
        System.out.println(sol.numberOfPairs(test1) == 0);
        System.out.println(sol.numberOfPairs(test2) == 2);
        System.out.println(sol.numberOfPairs(test3) == 2);
    }
}
