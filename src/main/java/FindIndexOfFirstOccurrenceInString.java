public class FindIndexOfFirstOccurrenceInString {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        int n = haystack.length();
        int m = needle.length();
        for (int i = 0; i <= n - m; i++) {
            if (haystack.substring(i, i + m).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindIndexOfFirstOccurrenceInString sol = new FindIndexOfFirstOccurrenceInString();
        System.out.println(sol.strStr("sadbutsad", "sad") == 0);
        System.out.println(sol.strStr("leetcode", "leeto") == -1);
        System.out.println(sol.strStr("leetcode", "etco") == 2);
        System.out.println(sol.strStr("mississippi", "issip") == 4);
        System.out.println(sol.strStr("a", "a") == 0);
    }
}
