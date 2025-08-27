import java.util.Arrays;

public class TrappingRainWater {
    public int trap(int[] height) {
        int water = 0;
        int left = 0, right = height.length - 1;
        int maxLeft = height[left], maxRight = height[right];
        while (left < right) {
            if (maxLeft < maxRight) {
                maxLeft = Math.max(maxLeft, height[++left]);
                water += maxLeft - height[left];
            } else {
                maxRight = Math.max(maxRight, height[--right]);
                water += maxRight - height[right];
            }
        }
        return water;
    }

    public static void main(String[] args) {
        TrappingRainWater sol = new TrappingRainWater();
        int[] test1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] test2 = {4, 2, 0, 3, 2, 5};
        System.out.println(sol.trap(test1) == 6);
        System.out.println(sol.trap(test2) == 9);
    }
}
