public class StringToInteger {
    public int myAtoi(String s) {
        s = s.strip();
        if (s.isEmpty()) {
            return 0;
        }
        long result = 0;
        int sign = 1;
        int i = 0;
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }
        int n = s.length();
        while (i < n) {
            char c = s.charAt(i);
            if (c <= '9' && c >= '0') {
                result = result * 10 + (c - '0');
                if (result * sign > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (result * sign < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
                i++;
            } else {
                break;
            }
        }
        result *= sign;
        return (int) result;
    }

    public static void main(String[] args) {
        StringToInteger test = new StringToInteger();
        System.out.println(test.myAtoi("42") == 42);
        System.out.println(test.myAtoi("   -042") == -42);
        System.out.println(test.myAtoi("1337c0d3") == 1337);
    }
}
