import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    private static final Map<Character, Integer> numerals = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
    );

    public int romanToInt(String s) {
        int result = 0;
        int n = s.length();
        int currentValue, lastValue;
        boolean subtract = false;
        for (int i = n - 1; i >= 0; i--) {
            currentValue = numerals.get(s.charAt(i));
            if (i < n - 1) {
                lastValue = numerals.get(s.charAt(i + 1));
                if (lastValue > currentValue) {
                    subtract = true;
                } else {
                    subtract = false;
                }
            }
            if (subtract) {
                result -= currentValue;
            } else {
                result += currentValue;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RomanToInteger test = new RomanToInteger();
        System.out.println(test.romanToInt("III") == 3);
        System.out.println(test.romanToInt("LVIII") == 58);
        System.out.println(test.romanToInt("MCMXCIV") == 1994);
    }
}
