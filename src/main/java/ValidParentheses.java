import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class ValidParentheses {
    private static final Map<Character, Character> map = Map.of(
            ')', '(', ']', '[', '}', '{'
    );

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if ("({[".contains(String.valueOf(c))) {
                stack.add(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else if (stack.getLast() == map.get(c)) {
                    stack.removeLast();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses sol = new ValidParentheses();
        System.out.println(sol.isValid("()"));
        System.out.println(sol.isValid("()[]{}"));
        System.out.println(!sol.isValid("(}"));
        System.out.println(!sol.isValid("({)}"));
        System.out.println(sol.isValid("({()(())})"));
    }
}
