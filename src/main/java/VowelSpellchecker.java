import java.util.*;

public class VowelSpellchecker {
    Set<String> perfectMatch;
    Map<String, String> capitalization;
    Map<String, String> vowelError;

    public String[] spellchecker(String[] wordlist, String[] queries) {
        perfectMatch = new HashSet<>();
        capitalization = new HashMap<>();
        vowelError = new HashMap<>();

        for (String word : wordlist) {
            perfectMatch.add(word);

            String wordLowercase = word.toLowerCase();
            capitalization.putIfAbsent(wordLowercase, word);

            String noVowels = devowel(wordLowercase);
            vowelError.putIfAbsent(noVowels, word);
        }

        String[] result = new String[queries.length];
        int t = 0;
        for (String query : queries) {
            result[t++] = solve(query);
        }
        return result;
    }

    private String solve(String query) {
        if (perfectMatch.contains(query)) return query;

        String queryLowercase = query.toLowerCase();
        if (capitalization.containsKey(queryLowercase)) return capitalization.get(queryLowercase);

        String queryNoVowels = devowel(queryLowercase);
        if (vowelError.containsKey(queryNoVowels)) return vowelError.get(queryNoVowels);

        return "";
    }

    private String devowel(String word) {
        StringBuilder result = new StringBuilder();
        for (char c : word.toCharArray()) {
            result.append(isVowel(c) ? '*' : c);
        }
        return result.toString();
    }

    private boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }

    public static void main(String[] args) {
        VowelSpellchecker sol = new VowelSpellchecker();
        System.out.println(Arrays.equals(sol.spellchecker(
                new String[]{"KiTe", "kite", "hare", "Hare"},
                new String[]{"kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto"}
        ), new String[]{"kite", "KiTe", "KiTe", "Hare", "hare", "", "", "KiTe", "", "KiTe"}));
        System.out.println(Arrays.equals(
                sol.spellchecker(new String[]{"yellow"}, new String[]{"YellOw"}),
                new String[]{"yellow"}
        ));
    }
}
