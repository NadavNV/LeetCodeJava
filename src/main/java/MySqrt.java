import java.util.Random;

public class MySqrt {
    public int mySqrt(int x) {
        int left = 0, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid == x) {
                return mid;
            } else if ((long) mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        MySqrt sol = new MySqrt();
        System.out.println(sol.mySqrt(4) == 2);
        System.out.println(sol.mySqrt(8) == 2);
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            int x = rand.nextInt(0, Integer.MAX_VALUE);
            System.out.println(sol.mySqrt(x) == (int) Math.sqrt(x));
        }
    }
}
