import java.util.Arrays;

public class WaysToExpressAnIntegerAsSumOfPowers {
    public int numberOfWays(int n, int x) {
        final int MOD = 1_000_000_007;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int power = (int) Math.pow(i, x);
            if (power > n) {
                break;
            }
            for (int j = n; j >= power; j--) {
                dp[j] = (dp[j] + dp[j - power]) % MOD;
            }
        }
        return (int) dp[n];
    }

    public static void main(String[] args) {
        WaysToExpressAnIntegerAsSumOfPowers test = new WaysToExpressAnIntegerAsSumOfPowers();
        System.out.println(test.numberOfWays(10, 2) == 1);
        System.out.println(test.numberOfWays(4, 1) == 2);
    }
}
