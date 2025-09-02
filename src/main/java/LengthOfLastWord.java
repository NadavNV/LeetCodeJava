public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String[] words = s.strip().split(" ");
        return words[words.length - 1].length();
    }
}
