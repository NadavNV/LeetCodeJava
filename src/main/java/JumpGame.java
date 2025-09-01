public class JumpGame {
    public boolean canJump(int[] nums) {
        int reach = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i <= reach) {
                reach = Math.max(reach, i + nums[i]);
            }
        }
        return reach >= nums.length - 1;
    }

    public static void main(String[] args) {
        JumpGame sol = new JumpGame();
        System.out.println(sol.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(!sol.canJump(new int[]{3, 2, 1, 0, 4}));
    }
}
