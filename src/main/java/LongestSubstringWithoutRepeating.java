import java.util.Arrays;

public class LongestSubstringWithoutRepeating {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int[] charIndex = new int[128];
        Arrays.fill(charIndex, -1);
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            if (charIndex[s.charAt(right)] >= left) {
                left = charIndex[s.charAt(right)] + 1;
            }
            charIndex[s.charAt(right)] = right;
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeating test = new LongestSubstringWithoutRepeating();
        System.out.printf(
                "for '%s' the answer is %d, expected %d%n",
                "abcabcbb",
                test.lengthOfLongestSubstring("abcabcbb"),
                3
        );
        System.out.printf(
                "for '%s' the answer is %d, expected %d%n",
                "bbbbb",
                test.lengthOfLongestSubstring("bbbbb"),
                1
        );
        System.out.printf(
                "for '%s' the answer is %d, expected %d%n",
                "pwwkew",
                test.lengthOfLongestSubstring("pwwkew"),
                3
        );
    }
}
