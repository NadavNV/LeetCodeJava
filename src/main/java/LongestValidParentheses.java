import java.util.Stack;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int n = s.length();
        boolean[] array = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') stack.push(i);
            if (s.charAt(i) == ')' && !stack.isEmpty()) {
                array[stack.pop()] = true;
                array[i] = true;
            }
        }
        int result = 0;
        int temp = 0;
        for (boolean hasMatch : array) {
            if (hasMatch) {
                result = Math.max(result, ++temp);
            } else {
                temp = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LongestValidParentheses sol = new LongestValidParentheses();
        System.out.println(sol.longestValidParentheses("(()") == 2);
        System.out.println(sol.longestValidParentheses(")()())") == 4);
        System.out.println(sol.longestValidParentheses("((((()())))") == 10);
    }
}
