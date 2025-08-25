public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        } else {
            return runLengthEncoding(countAndSay(n - 1));
        }
    }

    private String runLengthEncoding(String s) {
        StringBuilder encoding = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            int count = 1;

            while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                i++;
                count++;
            }
            encoding.append(count).append(s.charAt(i++));
        }
        return encoding.toString();
    }

    public static void main(String[] args) {
        CountAndSay sol = new CountAndSay();
        System.out.println(sol.runLengthEncoding("21").equals("1211"));
        System.out.println(sol.runLengthEncoding("3322251").equals("23321511"));
        System.out.println(sol.countAndSay(4).equals("1211"));
    }
}
