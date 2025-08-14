import java.util.Objects;
import java.util.Random;

public class LargestThreeSameDigitNumberInString {
    public String largestGoodInteger(String num) {
        int n = num.length();
        String result = "";
        int best = Integer.MIN_VALUE;
        if (n <= 2) {
            return result;
        }
        for (int i = 2; i < n; i++) {
            if (num.charAt(i) == num.charAt(i - 1) && num.charAt(i) == num.charAt(i - 2)) {
                int current = Integer.parseInt(num.substring(i - 2, i + 1));
                if (best < current) {
                    best = current;
                    if (current == 999) {
                        return "999";
                    }
                }
            }
        }
        if (best == Integer.MIN_VALUE) {
            return "";
        }
        if (best == 0) {
            return "000";
        }
        return String.valueOf(best);
    }

    public static void main(String[] args) {
        LargestThreeSameDigitNumberInString test = new LargestThreeSameDigitNumberInString();
        System.out.println(Objects.equals(test.largestGoodInteger("6777133339"), "777"));
        System.out.println(Objects.equals(test.largestGoodInteger("2300019"), "000"));
        System.out.println(Objects.equals(test.largestGoodInteger("42352338"), ""));
        StringBuilder longNumber = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            longNumber.append(random.nextInt(10));
        }
        longNumber.append(999);
        for (int i = 0; i < 800; i++) {
            longNumber.append(random.nextInt(10));
        }
        System.out.println(Objects.equals(test.largestGoodInteger(longNumber.toString()), "999"));
    }
}
