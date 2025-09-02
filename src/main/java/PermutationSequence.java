import java.util.Arrays;

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        int[] sequence = new int[n];
        for (int i = 0; i < n; i++) {
            sequence[i] = i + 1;
        }
        for (int i = 0; i < k - 1; i++) {
            nextPermutation(sequence);
        }
        StringBuilder result = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            result.append(sequence[i]);
        }
        return result.toString();
    }

    private void nextPermutation(int[] nums) {
        // https://en.wikipedia.org/wiki/Permutation#Generation_in_lexicographic_order
        int k = -1;
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                k = i;
            }
        }
        if (k == -1) {
            Arrays.sort(nums);
            return;
        }
        int l = -1;
        for (int i = k + 1; i < n; i ++) {
            if (nums[k] < nums[i]) {
                l = i;
            }
        }
        int temp = nums[k];
        nums[k] = nums[l];
        nums[l] = temp;
        for (int i = 0; i < (n - k) / 2; i++) {
            temp = nums[k + 1 + i];
            nums[k + 1 + i] = nums[n - 1 - i];
            nums[n - 1 - i] = temp;
        }
    }

    public static void main(String[] args) {
        PermutationSequence sol = new PermutationSequence();
        System.out.println(sol.getPermutation(3, 3).equals("213"));
        System.out.println(sol.getPermutation(3, 1).equals("123"));
        System.out.println(sol.getPermutation(4, 9).equals("2314"));
    }
}
