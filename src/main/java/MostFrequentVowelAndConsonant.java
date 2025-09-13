import java.util.HashMap;
import java.util.Map;

public class MostFrequentVowelAndConsonant {
    private static final String VOWELS = "aeiou";

    public int maxFreqSum(String s) {
        Map<Character, Integer> vowels = new HashMap<>();
        Map<Character, Integer> consonants = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (VOWELS.indexOf(c) != -1) {
                if (vowels.containsKey(c)) {
                    vowels.put(c, vowels.get(c) + 1);
                } else {
                    vowels.put(c, 1);
                }
            } else {
                if (consonants.containsKey(c)) {
                    consonants.put(c, consonants.get(c) + 1);
                } else {
                    consonants.put(c, 1);
                }
            }
        }
        int maxVowel = 0;
        int maxConsonant = 0;
        for (int freq : vowels.values()) {
            maxVowel = Math.max(freq, maxVowel);
        }
        for (int freq : consonants.values()) {
            maxConsonant = Math.max(freq, maxConsonant);
        }
        return maxConsonant + maxVowel;
    }

    public static void main(String[] args) {
        MostFrequentVowelAndConsonant sol = new MostFrequentVowelAndConsonant();
        System.out.println(sol.maxFreqSum("successes") == 6);
        System.out.println(sol.maxFreqSum("aeiaeia") == 3);
    }
}
