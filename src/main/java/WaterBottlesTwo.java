public class WaterBottlesTwo {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int consumedBottles = 0;
        while (numBottles >= numExchange) {
            consumedBottles += numExchange;
            numBottles -= numExchange;

            numBottles++;
            numExchange++;
        }

        return consumedBottles + numBottles;
    }

    public static void main(String[] args) {
        WaterBottlesTwo sol = new WaterBottlesTwo();
        System.out.println(sol.maxBottlesDrunk(13, 6) == 15);
        System.out.println(sol.maxBottlesDrunk(10, 3) == 13);
    }
}
