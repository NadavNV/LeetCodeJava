public class PowerOfThree {

    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        // Maximum power of 3 that fits in int
        int maxPower = (int) Math.pow(3, 19);
        return maxPower % n == 0;
    }

    public static void main(String[] args) {
        PowerOfThree test = new PowerOfThree();
        System.out.println(test.isPowerOfThree(27));
        System.out.println(test.isPowerOfThree(9));
        System.out.println(!test.isPowerOfThree(0));
        System.out.println(!test.isPowerOfThree(30));
        System.out.println(!test.isPowerOfThree(-1));
    }
}
