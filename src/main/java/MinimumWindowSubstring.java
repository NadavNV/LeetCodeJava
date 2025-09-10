public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int[] frequency = new int[128];
        for (char c : t.toCharArray()) {
            frequency[c]++;
        }
        int missingChars = t.length();
        int left = 0, right = 0;
        int bestLength = Integer.MAX_VALUE;
        int startIndex = 0;
        while (right < s.length()) {
            if (frequency[s.charAt(right)] > 0) {
                missingChars--;
            }
            frequency[s.charAt(right)]--;
            right++;

            while (missingChars == 0) {
                if (right - left < bestLength) {
                    bestLength = right - left;
                    startIndex = left;
                }

                if (frequency[s.charAt(left)] == 0) {
                    missingChars++;
                }
                frequency[s.charAt(left)]++;
                left++;
            }
        }
        return (bestLength == Integer.MAX_VALUE) ? "" : s.substring(startIndex, startIndex + bestLength);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring sol = new MinimumWindowSubstring();
        System.out.println(sol.minWindow("ADOBECODEBANC", "ABC").equals("BANC"));
        System.out.println(sol.minWindow("a", "a").equals("a"));
        System.out.println(sol.minWindow("a", "aa").isEmpty());
    }
}
