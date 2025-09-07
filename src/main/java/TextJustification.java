import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < words.length) {
            List<String> currentLineList = new ArrayList<>();
            while (String.join(" ", currentLineList).length() < maxWidth && i < words.length) {
                String nextWord = words[i++];
                currentLineList.add(nextWord);
            }
            if (String.join(" ", currentLineList).length() > maxWidth) {
                currentLineList.removeLast();
                i--;
            }
            if (i == words.length) {
                // Last line
                String currentLine = String.join(" ", currentLineList);
                currentLine += " ".repeat(Math.max(0, maxWidth - currentLine.length()));
                result.add(currentLine);
                return result;
            }
            String currentLine = String.join(" ", currentLineList);
            while (currentLine.length() < maxWidth) {
                currentLine = addSpaces(currentLine, maxWidth);
            }
            result.add(currentLine);
        }
        return result;
    }

    private String addSpaces(String s, int width) {
        int toAdd = width - s.length();
        if (!s.contains(" ")) {
            return s + " ".repeat(toAdd);
        }
        int i = 0;
        while (toAdd > 0) {
            if (i + 1 < s.length() && s.charAt(i) != ' ' && s.charAt(i + 1) == ' ') {
                s = s.substring(0, i + 1) + " " + s.substring(i + 1);
                toAdd--;
            }
            i = (i + 1) % s.length();
        }
        return s;
    }

    public static void main(String[] args) {
        TextJustification sol = new TextJustification();
        String[] test1 = {"This", "is", "an", "example", "of", "text", "justification."};
        List<String> expected1 = List.of(
                "This    is    an",
                "example  of text",
                "justification.  "
        );
        String[] test2 = {"What", "must", "be", "acknowledgment", "shall", "be"};
        List<String> expected2 = List.of(
                "What   must   be",
                "acknowledgment  ",
                "shall be        "
        );
        String[] test3 = {
                "Science",
                "is",
                "what",
                "we",
                "understand",
                "well",
                "enough",
                "to",
                "explain",
                "to",
                "a",
                "computer.",
                "Art",
                "is",
                "everything",
                "else",
                "we",
                "do"
        };
        List<String> expected3 = List.of(
                "Science  is  what we",
                "understand      well",
                "enough to explain to",
                "a  computer.  Art is",
                "everything  else  we",
                "do                  "
        );
        System.out.println(sol.fullJustify(test1, 16).equals(expected1));
        System.out.println(sol.fullJustify(test2, 16).equals(expected2));
        System.out.println(sol.fullJustify(test3, 20).equals(expected3));
    }
}
