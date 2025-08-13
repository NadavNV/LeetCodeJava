import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LetterCombinationsOfAPhoneNumber {
    private static final Map<Character, List<String>> keyMapping = Map.of(
            '2', List.of("a", "b", "c"),
            '3', List.of("d", "e", "f"),
            '4', List.of("g", "h", "i"),
            '5', List.of("j", "k", "l"),
            '6', List.of("m", "n", "o"),
            '7', List.of("p", "q", "r", "s"),
            '8', List.of("t", "u", "v"),
            '9', List.of("w", "x", "y", "z")
    );

    private static List<String> combine(List<String> a, List<String> b) {
        List<String> result = new ArrayList<>(a.size() * b.size());
        for (String aString : a) {
            for (String bString : b) {
                result.add(aString + bString);
            }
        }
        return result;
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return List.of();
        }
        if (digits.length() == 1) {
            return keyMapping.get(digits.charAt(0));
        }
        int n = digits.length();
        return combine(letterCombinations(digits.substring(0, n / 2)), letterCombinations(digits.substring(n / 2)));
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber test = new LetterCombinationsOfAPhoneNumber();
        System.out.println(Objects.equals(test.letterCombinations("23"),
                List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")));
        System.out.println(Objects.equals(test.letterCombinations(""), List.of()));
        System.out.println(Objects.equals(test.letterCombinations("2"),
                List.of("a", "b", "c")));
    }
}
