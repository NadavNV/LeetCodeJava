import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumAveragePassRatio {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> heap = new PriorityQueue<>(Comparator.comparingDouble(a -> a[0]));
        for (int[] cls : classes) {
            double increase = computeIncrease(cls[0], cls[1]);
            heap.add(new double[]{-increase, cls[0], cls[1]});
        }
        for (int i = 0; i < extraStudents; i++) {
            double[] nextClass = heap.poll();
            nextClass[0] = -computeIncrease(++nextClass[1], ++nextClass[2]);
            heap.add(nextClass);
        }
        double sum = 0.0;
        Object[] array = heap.toArray();
        for (Object o : array) {
            double[] cls = (double[]) o;
            sum += cls[1] / cls[2];
        }
        return sum / classes.length;
    }

    private double computeIncrease(double pass, double total) {
        double current = pass / total;
        double addStudent = (pass + 1) / (total + 1);
        return addStudent - current;
    }

    public static void main(String[] args) {
        MaximumAveragePassRatio sol = new MaximumAveragePassRatio();
        int[][] test1 = {{1, 2}, {3, 5}, {2, 2}};
        int[][] test2 = {{2, 4}, {3, 9}, {4, 5}, {2, 10}};
        double epsilon = Math.pow(10, -5);
        System.out.println(Math.abs(sol.maxAverageRatio(test1, 2) - 0.78333) < epsilon);
        System.out.println(Math.abs(sol.maxAverageRatio(test2, 4) - 0.53485) < epsilon);
    }
}
