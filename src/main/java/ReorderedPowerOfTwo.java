import java.util.HashMap;
import java.util.Map;

public class ReorderedPowerOfTwo {
    private static final Map<String, Integer> powersOfTwo = new HashMap<>();

    static {
        String digits;
        for (int i = 0; Math.pow(2, i) < Math.pow(10, 9); i++) {
            digits = countDigits((int) Math.pow(2, i));
            if (powersOfTwo.containsKey(digits)) {
                powersOfTwo.put(digits, powersOfTwo.get(digits) + 1);
            } else {
                powersOfTwo.put(digits, 1);
            }
        }
    }

    public boolean reorderedPowerOf2(int n) {
        if (Integer.bitCount(n) == 1) {
            return true;
        }
        return powersOfTwo.containsKey(countDigits(n));
    }

    private static String countDigits(int n) {
        int[] histogram = new int[10];
        int original = n;
        while (n > 0) {
            histogram[n % 10]++;
            n = Math.floorDiv(n, 10);
        }
        StringBuilder sb = new StringBuilder(10);
        for (int digit : histogram) {
            sb.append(digit);
        }
        return sb.toString();
    }
}
