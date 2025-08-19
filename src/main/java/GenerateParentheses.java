import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    private static class DFS {
        int n;
        List<String> result;

        public DFS(int n, List<String> result) {
            this.n = n;
            this.result = result;
        }

        public void solve(int opening, int closing, String string) {
            if (string.length() == 2 * n) {
                result.add(string);
                return;
            }

            if (opening < n) {
                solve(opening + 1, closing, string + "(");
            }
            if (closing < opening) {
                solve(opening, closing + 1, string + ")");
            }
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        new DFS(n, result).solve(0, 0, "");
        return result;
    }

    public static void main(String[] args) {
        GenerateParentheses sol = new GenerateParentheses();
        System.out.println(sol.generateParenthesis(3));
    }
}
