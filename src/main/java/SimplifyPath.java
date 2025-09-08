import java.util.ArrayList;
import java.util.List;

public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] words = path.split("/+", 0);
        List<String> stack = new ArrayList<>();
        for (String word : words) {
            switch (word) {
                case ".", "" -> {
                    // Do nothing
                }
                case ".." -> {
                    if (!stack.isEmpty()) {
                        stack.removeLast();
                    }
                }
                default -> stack.add(word);
            }
        }
        return "/" + String.join("/", stack);
    }

    public static void main(String[] args) {
        SimplifyPath sol = new SimplifyPath();
        String[] test = {
                "/home/",
                "/home//foo/",
                "/home/user/Documents/../Pictures",
                "/../",
                "/.../a/../b/c/../d/./",
                "/a/../../b/../c//.//"
        };
        String[] expected = {
                "/home",
                "/home/foo",
                "/home/user/Pictures",
                "/",
                "/.../b/d",
                "/c"
        };
        for (int i = 0; i < test.length; i++) {
            System.out.println(sol.simplifyPath(test[i]).equals(expected[i]));
        }
    }
}
