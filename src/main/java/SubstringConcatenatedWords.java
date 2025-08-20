import java.util.*;

public class SubstringConcatenatedWords {
    public List<Integer> findSubstring(String s, String[] words) {
        int stringLength = s.length();
        int numWords = words.length;
        int wordLength = words[0].length();
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }
        // Check if the substring starts at this offset from 0
        for (int offset = 0; offset < wordLength; offset++) {
            Map<String, Integer> usedWords = new HashMap<>();
            int left = offset, right = offset;
            int count = 0;
            while (right + wordLength <= stringLength) {
                String word = s.substring(right, right + wordLength);
                right += wordLength;
                if (!wordCount.containsKey(word)) {
                    // Not one of the necessary words, reset
                    left = right;
                    usedWords.clear();
                    count = 0;
                    continue;
                }
                if (usedWords.containsKey(word)) {
                    usedWords.put(word, usedWords.get(word) + 1);
                } else {
                    usedWords.put(word, 1);
                }
                count++;
                while (usedWords.get(word) > wordCount.get(word)) {
                    String remove = s.substring(left, left + wordLength);
                    left += wordLength;
                    usedWords.put(remove, usedWords.get(remove) - 1);
                    count--;
                }
                if (count == numWords) {
                    result.add(left);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SubstringConcatenatedWords sol = new SubstringConcatenatedWords();
        System.out.println(Objects.equals(
                sol.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}),
                List.of(0, 9)
        ));
        System.out.println(Objects.equals(
                sol.findSubstring("barfoothfoobarman", new String[]{"foo", "bar"}),
                List.of(0, 8)
        ));
        System.out.println(Objects.equals(
                sol.findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"}),
                List.of()
        ));
        System.out.println(Objects.equals(
                sol.findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"}),
                List.of(8)
        ));
        System.out.println(Objects.equals(
                sol.findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}),
                List.of(6, 9, 12)
        ));
    }
}
