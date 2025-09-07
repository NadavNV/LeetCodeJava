import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        ArrayList<Integer> result = new ArrayList<>(digits.length);
        int i = digits.length - 1, carry = 1;
        while (i >= 0) {
            int digit = digits[i--] + carry;
            if (digit >= 10) {
                carry = digit / 10;
                digit %= 10;
            } else {
                carry = 0;
            }
            result.add(digit);
        }
        while (carry != 0) {
            result.add(carry % 10);
            carry /= 10;
        }
        Collections.reverse(result);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        PlusOne sol = new PlusOne();
        int[][] test = {
                {1, 2, 3},
                {4, 3, 2, 1},
                {9},
                {5, 5, 9, 9, 9}
        };
        int[][] expected = {
                {1, 2, 4},
                {4, 3, 2, 2},
                {1, 0},
                {5, 6, 0, 0, 0}
        };
        for (int i = 0; i < test.length; i++) {
            System.out.println(Arrays.equals(sol.plusOne(test[i]), expected[i]));
        }
    }
}
