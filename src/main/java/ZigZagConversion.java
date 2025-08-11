import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int j = 0; j < numRows; j++) {
            rows[j] = new StringBuilder();
        }
        int i = 0;
        int row = 0;
        boolean ascending = false;
        while (i < s.length()) {
            rows[row].append(s.charAt(i++));
            if (ascending) {
                if (row == 0) {
                    ascending = false;
                    row = 1;
                } else {
                    row -= 1;
                }
            } else {
                if (row == numRows - 1) {
                    ascending = true;
                    row -= 1;
                } else {
                    row += 1;
                }
            }
        }
        return Arrays.stream(rows).map(StringBuilder::toString).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        ZigZagConversion test = new ZigZagConversion();
        System.out.println(Objects.equals(test.convert("PAYPALISHIRING", 3), "PAHNAPLSIIGYIR"));
        System.out.println(Objects.equals(test.convert("PAYPALISHIRING", 4), "PINALSIGYAHRPI"));
        System.out.println(Objects.equals(test.convert("A", 1), "A"));
    }
}
