public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int prev = 2, prevPrev = 1;
        int current = prev + prevPrev;
        for (int i = 3; i < n; i++) {
            prevPrev = prev;
            prev = current;
            current = prev + prevPrev;
        }
        return current;
    }
}
