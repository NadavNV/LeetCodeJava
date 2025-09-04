public class FindClosestPerson {
    public int findClosest(int x, int y, int z) {
        int xDist = Math.abs(z - x);
        int yDist = Math.abs(z - y);
        if (xDist == yDist) {
            return 0;
        } else {
            return (xDist > yDist) ? 2 : 1;
        }
    }
}
