public class MaximumWordsYouCanType {
    public int canBeTypedWords(String text, String brokenLetters) {
        int result = 0;
        String[] words = text.split(" +");
        for (String word : words) {
            boolean canBeTyped = true;
            for (char c : brokenLetters.toCharArray()) {
                if (word.indexOf(c) != -1) {
                    canBeTyped = false;
                    break;
                }
            }
            if (canBeTyped) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MaximumWordsYouCanType sol = new MaximumWordsYouCanType();
        System.out.println(sol.canBeTypedWords("hello world", "ad") == 1);
        System.out.println(sol.canBeTypedWords("leet code", "lt") == 1);
        System.out.println(sol.canBeTypedWords("leet code", "e") == 0);
    }
}
