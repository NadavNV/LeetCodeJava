import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int current = nums[i] + nums[start] + nums[end];
                if (current == target) {
                    return current;
                }
                if (Math.abs(current - target) < diff) {
                    diff = Math.abs(current - target);
                    answer = current;
                }
                if (current > target) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        ThreeSumClosest test = new ThreeSumClosest();
        System.out.println(test.threeSumClosest(new int[]{-1, 2, 1, -4}, 1) == 2);
        System.out.println(test.threeSumClosest(new int[]{0, 0, 0}, 1) == 0);
    }
}
