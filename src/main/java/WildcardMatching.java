public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        // isMatch[i,j] is true if s[i:] matches p[j:]
        boolean[][] isMatch = new boolean[n + 1][m + 1];
        for (int i = n; i >= 0; i--) {
            for (int j = m; j >= 0; j--) {
                if (j == m) {
                    if (i == n) {
                        isMatch[i][j] = true;
                    } else {
                        isMatch[i][j] = false;
                    }
                } else {
                    if (i < n && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                        isMatch[i][j] = isMatch[i + 1][j + 1];
                    } else if (p.charAt(j) == '*') {
                        for (int k = i; k <= n; k++) {
                            if (isMatch[k][j + 1]) {
                                isMatch[i][j] = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return isMatch[0][0];
    }

    public static void main(String[] args) {
        WildcardMatching sol = new WildcardMatching();
        System.out.println(!sol.isMatch("aa", "a"));
        System.out.println(sol.isMatch("aa", "*"));
        System.out.println(!sol.isMatch("cb", "?a"));
        System.out.println(sol.isMatch("adceb", "*a*b"));
        System.out.println(!sol.isMatch("acdcb", "a*c?b"));
    }
}
