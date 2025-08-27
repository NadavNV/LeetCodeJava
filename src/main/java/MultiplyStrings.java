import java.util.Random;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        StringBuilder s1 = new StringBuilder(num1).reverse();
        StringBuilder s2 = new StringBuilder(num2).reverse();
        for (int i = 0; i < s1.length(); i++) {
            StringBuilder temp = new StringBuilder("0".repeat(i));
            int carry = 0;
            for (int j = 0; j < s2.length(); j++) {
                int digit = (s1.charAt(i) - '0') * (s2.charAt(j) - '0') + carry;
                if (digit >= 10) {
                    carry = digit / 10;
                    digit %= 10;
                } else {
                    carry = 0;
                }
                temp.append(digit);
            }
            while (carry != 0) {
                temp.append(carry % 10);
                carry /= 10;
            }
            result = new StringBuilder(add(result.toString(), temp.toString()));
        }
        return result.reverse().toString();
    }

    private String add (String num1, String num2) {
        // Assume numbers are given reversed, i.e. the least significant digits first
        StringBuilder result = new StringBuilder();
        int carry = 0, i = 0;
        while (i < num1.length() && i < num2.length()) {
            int digit = (num1.charAt(i) - '0') + (num2.charAt(i) - '0') + carry;
            if (digit >= 10) {
                carry = digit / 10;
                digit %= 10;
            } else {
                carry = 0;
            }
            result.append(digit);
            i++;
        }

        while (i < num1.length()) {
            int digit = (num1.charAt(i++) - '0') + carry;
            if (digit >= 10) {
                carry = digit / 10;
                digit %= 10;
            } else {
                carry = 0;
            }
            result.append(digit);
        }
        while (i < num2.length()) {
            int digit = (num2.charAt(i++) - '0') + carry;
            if (digit >= 10) {
                carry = digit / 10;
                digit %= 10;
            } else {
                carry = 0;
            }
            result.append(digit);
        }
        while (carry != 0) {
            result.append(carry % 10);
            carry /= 10;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        MultiplyStrings sol = new MultiplyStrings();
        System.out.println(sol.multiply("2", "3").equals("6"));
        System.out.println(sol.multiply("123", "456").equals("56088"));
        Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            long x = rand.nextLong((long) Math.sqrt(Long.MAX_VALUE));
            long y = rand.nextLong((long) Math.sqrt(Long.MAX_VALUE));
            System.out.println(sol.multiply(String.valueOf(x), String.valueOf(y)).equals(String.valueOf(x * y)));
        }
    }
}
