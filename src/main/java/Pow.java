import java.util.Random;

public class Pow {
    public double myPow(double x, int n) {
        return helper(x, n);
    }

    // Using long to handle -Integer.MIN_VALUE
    private double helper(double x, long n) {
        if (x == 0) return 0.0;
        if (n == 0) return 1.0;
        if (n < 0) return 1.0 / helper(x, -n);
        if (n % 2 == 0) {
            return helper(x * x, n / 2);
        } else {
            return x * helper(x * x, (n - 1) / 2);
        }
    }

    public static void main(String[] args) {
        Pow sol = new Pow();
        System.out.println(sol.myPow(2.0, 10) == Math.pow(2.0, 10));
        System.out.println(sol.myPow(2.1, 3) == Math.pow(2.1, 3));
        System.out.println(sol.myPow(2.0, -2) == Math.pow(2.0, -2));
        Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            double x = rand.nextDouble(-100, 100);
            int n = rand.nextInt();
            System.out.println(sol.myPow(x, n) == Math.pow(x, n));
        }
    }
}
