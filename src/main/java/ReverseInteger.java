public class ReverseInteger {
    public int reverse(int x) {
        if (x == 0) return 0;
        int sign = x / Math.abs(x);
        int result = 0;
        x = Math.abs(x);
        while (x > 0) {
            int digit = x % 10;
            x /= 10;
            if (sign > 0) {
                if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                    return 0;
                }
            } else {
                if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 8)) {
                    return 0;
                }
            }
            result = result * 10 + digit;
        }
        return result * sign;
    }

    public static void main(String[] args) {
        ReverseInteger test = new ReverseInteger();
        System.out.println(test.reverse(123)/* == 321*/);
        System.out.println(test.reverse(-123)/* == -321*/);
        System.out.println(test.reverse(120)/* == 21*/);
    }
}
