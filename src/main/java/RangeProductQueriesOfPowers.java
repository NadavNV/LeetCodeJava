import java.util.Arrays;

public class RangeProductQueriesOfPowers {
    public int[] productQueries(int n, int[][] queries) {
        int[] powersArray = getPowersArray(n);
        int[] result = new int[queries.length];
        int j = 0;
        int modulu = (int) Math.pow(10, 9) + 7;
        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];
            long product = 1L;
            for (int i = start; i <= end; i++) {
                product = (product * powersArray[i]) % modulu;
            }
            result[j++] = (int) product;
        }
        return result;
    }

    private static int[] getPowersArray(int n) {
        int[] result = new int[Integer.bitCount(n)];
        String bits = Integer.toBinaryString(n);
        int j = result.length - 1;
        for (int i = 0; i < bits.length(); i++) {
            if (bits.charAt(i) == '1') {
                result[j--] = 1 << (bits.length() - 1 - i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RangeProductQueriesOfPowers test = new RangeProductQueriesOfPowers();
        System.out.println(Arrays.toString(test.productQueries(15, new int[][]{
                {0, 1}, {2, 2}, {0, 3}
        })));
        System.out.println(Arrays.toString(test.productQueries(2, new int[][]{
                {0, 0}
        })));
    }
}
