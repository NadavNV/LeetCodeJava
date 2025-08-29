public class AliceBobFlowerGame {
    public long flowerGame(int n, int m) {
        if (n == m & n == 1) {
            return 0;
        }
        long oddsN = (n % 2 == 0) ? n / 2 : n / 2 + 1, evensN = n / 2;
        long oddsM = (m % 2 == 0) ? m / 2 : m / 2 + 1, evensM = m / 2;
        return oddsN * evensM + oddsM * evensN;
    }

    public static void main(String[] args) {
        AliceBobFlowerGame sol = new AliceBobFlowerGame();
        System.out.println(sol.flowerGame(3, 2) == 3);
        System.out.println(sol.flowerGame(1, 1) == 0);
    }
}
