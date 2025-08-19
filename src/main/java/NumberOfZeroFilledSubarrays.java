import java.util.Arrays;

public class NumberOfZeroFilledSubarrays {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;
        long result = 0;
        for (int num : nums) {
            if (num == 0) {
                count++;
                result += count;
            } else{
                count = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        NumberOfZeroFilledSubarrays sol = new NumberOfZeroFilledSubarrays();
        System.out.println(sol.zeroFilledSubarray(new int[]{1, 3, 0, 0, 2, 0, 0, 4}) == 6);
        System.out.println(sol.zeroFilledSubarray(new int[]{0, 0, 0, 2, 0, 0}) == 9);
        System.out.println(sol.zeroFilledSubarray(new int[]{2, 10, 2019}) == 0);
    }
}
