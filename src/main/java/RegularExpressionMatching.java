public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        // isMatch[i,j] is true if s[:i] matches p[:j]
        boolean[][] isMatch = new boolean[n + 1][m + 1];
        isMatch[0][0] = true;
        isMatch[0][1] = p.charAt(0) == '*';
        for (int j = 2; j <= m; j++) {
            if (p.charAt(j - 1) == '*') {
                // match zero occurrences of the preceding element
                isMatch[0][j] = isMatch[0][j - 2];
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    isMatch[i][j] = isMatch[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    isMatch[i][j] = isMatch[i][j - 2];  // match zero occurrences
                    if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) {
                        isMatch[i][j] = isMatch[i][j] || isMatch[i - 1][j];
                    }
                }
            }
        }
        return isMatch[n][m];
    }

    public static void main(String[] args) {
        RegularExpressionMatching test = new RegularExpressionMatching();
        System.out.println(!test.isMatch("aa", "a"));
        System.out.println(test.isMatch("aa", "a*"));
        System.out.println(test.isMatch("ab", ".*"));
    }
}
