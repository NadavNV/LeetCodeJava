public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0, high = matrix.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int[] row = matrix[mid];
            if (row[0] <= target && target <= row[row.length - 1]) {
                return searchInRow(row, target);
            } else if (target < row[0]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    private boolean searchInRow(int[] row, int target) {
        int left = 0, right = row.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (row[mid] == target) {
                return true;
            }
            if (row[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Search2DMatrix sol = new Search2DMatrix();
        System.out.println(sol.searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        }, 3));
        System.out.println(sol.searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        }, 16));
        System.out.println(!sol.searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        }, 13));
        System.out.println(!sol.searchMatrix(new int[][]{{1}}, 3));
    }
}
