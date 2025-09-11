import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortVowelsInString {
    private static final String VOWELS = "AEIOUaeiou";

    public String sortVowels(String s) {
        List<Character> vowels = new ArrayList<>();

        for (char c : s.toCharArray()) {
            if (VOWELS.indexOf(c) != -1) {
                vowels.add(c);
            }
        }

        vowels.sort(Comparator.naturalOrder());

        int vowelsIndex = 0;
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (VOWELS.indexOf(c) != -1) {
                result.append(vowels.get(vowelsIndex++));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        SortVowelsInString sol = new SortVowelsInString();
        System.out.println(sol.sortVowels("lEetcOde").equals("lEOtcede"));
        System.out.println(sol.sortVowels("lYmpH").equals("lYmpH"));
        System.out.println(sol.sortVowels("wUMnwnblpu").equals("wUMnwnblpu"));
        System.out.println(sol.sortVowels("RUnxytMua").equals("RUnxytMau"));
    }
}
