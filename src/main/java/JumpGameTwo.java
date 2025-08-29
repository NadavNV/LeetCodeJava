public class JumpGameTwo {
    public int jump(int[] nums) {
        // Reach is the farthest index we've reached so far
        // Last is the farthest index we can reach with the
        // current number of jumps
        int jumps = 0, reach = 0, last = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            reach = Math.max(reach, i + nums[i]);
            if (i == last) {
                last = reach;
                jumps++;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        JumpGameTwo sol = new JumpGameTwo();
        System.out.println(sol.jump(new int[]{2, 3, 1, 1, 4}) == 2);
        System.out.println(sol.jump(new int[]{2, 3, 0, 1, 4}) == 2);
    }
}
