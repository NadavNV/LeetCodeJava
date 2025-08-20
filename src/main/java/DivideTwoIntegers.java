public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            return -dividend;
        }
        // Work with negatives for overflow safety
        int negatives = 2;
        if (divisor > 0) {
            divisor = -divisor;
            negatives--;
        }
        if (dividend > 0) {
            dividend = -dividend;
            negatives--;
        }
        int quotient = 0;
        while (dividend <= divisor) {
            // dividend = q * divisor + remainder
            // Find the greatest p such that dividend > (2^p) * divisor
            int powerOfTwo = -1;
            int value = divisor;
            while (value >= (Integer.MIN_VALUE >> 1) && dividend <= value + value) {
                value += value;
                powerOfTwo += powerOfTwo;
            }
            // dividend = (2^p) * divisor + X * divisor + remainder
            // Add 2^p to our answer
            // dividend - (2^p) * divisor = X * divisor + remainder
            // Again we have D = X * divisor + remainder
            // So we repeat the process
            dividend -= value;
            quotient += powerOfTwo;
        }
        // quotient is negative
        return (negatives == 1) ? quotient : -quotient;
    }

    public static void main(String[] args) {
        DivideTwoIntegers sol = new DivideTwoIntegers();
        System.out.println(sol.divide(10, 3) == 3);
        System.out.println(sol.divide(7, -3) == -2);
        System.out.println(sol.divide(Integer.MIN_VALUE, 2) == -1073741824);
    }
}
