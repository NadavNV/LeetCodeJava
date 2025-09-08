public class ConvertIntegerToSumOfNoZero {
    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i <= n / 2; i++) {
            if (isNoZero(i) && isNoZero(n - i)) {
                return new int[]{i, n-i};
            }
        }
        return new int[]{-1, -1};
    }

    private boolean isNoZero(int n) {
        while (n > 0) {
            if (n % 10 == 0) {
                return false;
            }
            n /= 10;
        }
        return true;
    }
}
