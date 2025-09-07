public class MinimumOperationsToMakeIntegerZero {
    public int makeTheIntegerZero(int num1, int num2) {
        for (int k = 1; k <= 60; k++) {
            long num = num1 - (long) k * num2;
            if (num <= 0) break;
            if (num >= k && Long.bitCount(num) <= k) return k;
        }
        return -1;
    }

    public static void main(String[] args) {
        MinimumOperationsToMakeIntegerZero sol = new MinimumOperationsToMakeIntegerZero();
        System.out.println(sol.makeTheIntegerZero(3, -2) == 3);
        System.out.println(sol.makeTheIntegerZero(5, 7) == -1);
    }
}
