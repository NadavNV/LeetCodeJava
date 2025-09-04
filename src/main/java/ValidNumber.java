import java.util.regex.Pattern;

public class ValidNumber {
    public boolean isNumber(String s) {
        s = s.toLowerCase();
        boolean isDigit = false;
        boolean isExponent = false;
        boolean isDot = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                isDigit = true;
            } else if (c == '-' || c == '+') {
                if (i > 0 && s.charAt(i - 1) != 'e') return false;
            } else if (c == 'e') {
                if (isExponent || !isDigit) return false;
                isExponent = true;
                isDigit = false;
            } else if (c == '.') {
                if (isDot || isExponent) return false;
                isDot = true;
            } else {
                return false;
            }
        }
        return isDigit;
    }

    public static void main(String[] args) {
        ValidNumber sol = new ValidNumber();
        String[] valid = {"2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7",
                "+6e-1", "53.5e93", "-123.456e789", ".4"};
        String[] invalid = {"0..", "abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53", "4e+"};
        for (String s : valid) {
            if (!sol.isNumber(s)) System.out.printf("%s should be valid%n", s);
        }
        for (String s : invalid) {
            if (sol.isNumber(s)) System.out.printf("%s should be invalid%n", s);
        }
        sol.isNumber("0..");
    }
}
