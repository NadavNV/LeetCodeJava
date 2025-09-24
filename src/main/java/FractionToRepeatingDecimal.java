import java.util.ArrayList;
import java.util.List;

public class FractionToRepeatingDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder result = new StringBuilder();
        long num = (long) numerator, denom = (long) denominator;
        if (num * denom < 0) {
            num = Math.abs(num);
            denom = Math.abs(denom);
            result.append('-');
        }
        result.append(num / denom);
        long dividend = num % denom;
        if (dividend == 0) return result.toString();
        result.append('.');
        List<Integer> digits = new ArrayList<>();
        List<Long> seen = new ArrayList<>();
        int repeatingStart = 0;
        boolean repeating = false;
        while (dividend != 0) {
            dividend *= 10;
            long nextDigit = dividend / denom;
            if (seen.contains(dividend)) {
                repeating = true;
                repeatingStart = seen.indexOf(dividend);
                break;
            } else {
                digits.add((int)nextDigit);
                seen.add(dividend);
                dividend %= denom;
            }
        }
        for (int i = 0; i < digits.size(); i++) {
            if (repeating && i == repeatingStart) {
                result.append('(');
            }
            result.append(digits.get(i));
        }
        if (repeating) {
            result.append(')');
        }
        return result.toString();
    }

    public static void main(String[] args) {
        FractionToRepeatingDecimal sol = new FractionToRepeatingDecimal();
        System.out.println(sol.fractionToDecimal(1, 2).equals("0.5"));
        System.out.println(sol.fractionToDecimal(2, 1).equals("2"));
        System.out.println(sol.fractionToDecimal(4, 333).equals("0.(012)"));
        System.out.println(sol.fractionToDecimal(1, 333).equals("0.(003)"));
        System.out.println(sol.fractionToDecimal(3227, 555).equals("5.8(144)"));
        System.out.println(sol.fractionToDecimal(7, -12).equals("-0.58(3)"));
    }
}
