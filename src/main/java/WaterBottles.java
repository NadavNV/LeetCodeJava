public class WaterBottles {
    public int numWaterBottles(int numBottles, int numExchange) {
        int consumedBottles = 0;
        while (numBottles >= numExchange) {
            int k = numBottles / numExchange;
            consumedBottles += k * numExchange;
            numBottles -= k * numExchange;

            numBottles += k;
        }

        return consumedBottles + numBottles;
    }

    public static void main(String[] args) {
        WaterBottles sol = new WaterBottles();
        System.out.println(sol.numWaterBottles(9, 3) == 13);
        System.out.println(sol.numWaterBottles(15, 4) == 19);
    }
}
