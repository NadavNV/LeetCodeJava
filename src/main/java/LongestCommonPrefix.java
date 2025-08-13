import java.util.Arrays;
import java.util.Objects;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        // high = length of shortest string
        int low = 1, high = Arrays.stream(strs)
                .map(String::length)
                .min(Integer::compareTo).orElseThrow();
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle)) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private boolean isCommonPrefix(String[] strs, int length) {
        String prefix = strs[0].substring(0, length);
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(prefix)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LongestCommonPrefix test = new LongestCommonPrefix();
        System.out.println(Objects.equals(test.longestCommonPrefix(new String[]{"flower", "flow", "flight"}), "fl"));
        System.out.println(Objects.equals(test.longestCommonPrefix(new String[]{"flower", "flow"}), "flow"));
        System.out.println(Objects.equals(test.longestCommonPrefix(new String[]{"dog", "racecar", "car"}), ""));
        System.out.println(Objects.equals(test.longestCommonPrefix(new String[]{"howard", "", "howitzer"}), ""));
    }
}
