import java.util.Objects;

public class LongestPalindromeSubstring {

    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        int start = 0, end = 0;
        for (int mid = 0; mid < s.length(); mid++) {
            int lengthOdd = expandAroundCenter(s, mid, mid);
            int lengthEven = expandAroundCenter(s, mid, mid + 1);
            int length = Math.max(lengthOdd, lengthEven);
            if (length > end - start) {
                start = mid - (length - 1) / 2;
                end = mid + length / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        LongestPalindromeSubstring test = new LongestPalindromeSubstring();
        System.out.println(Objects.equals(test.longestPalindrome("babad"), "bab") ||
                Objects.equals(test.longestPalindrome("babad"), "aba"));
        System.out.println(Objects.equals(test.longestPalindrome("cbbd"), "bb"));
        System.out.println(Objects.equals(test.longestPalindrome("ac"), "a") ||
                Objects.equals(test.longestPalindrome("ac"), "c"));
        System.out.println(test.longestPalindrome("kztakrekvefgchersuoiuatzlmwynzjhdqqftjcqmntoyckqfawikk" +
                "drnfgbwtdpbkymvwoumurjdzygyzsbmwzpcxcdmmpwzmeibligwiiqbecxwyxigikoewwrczkanwwqukszsbjukzumz" +
                "ladrvjefpegyicsgctdvldetuegxwihdtitqrdmygdrsweahfrepdcudvyvrggbkthztxwicyzazjyeztytwiyybqds" +
                "czozvtegodacdokczfmwqfmyuixbeeqluqcqwxpyrkpfcdosttzooykpvdykfxulttvvwnzftndvhsvpgrgdzsvfxdtz" +
                "ztdiswgwxzvbpsjlizlfrlgvlnwbjwbujafjaedivvgnbgwcdbzbdbprqrflfhahsvlcekeyqueyxjfetkxpapbeejox" +
                "wxlgepmxzowldsmqllpzeymakcshfzkvyykwljeltutdmrhxcbzizihzinywggzjctzasvefcxmhnusdvlderconvais" +
                "aetcdldeveeemhugipfzbhrwidcjpfrumshbdofchpgcsbkvaexfmenpsuodatxjavoszcitjewflejjmsuvyuyrkume" +
                "dnsfkbgvbqxfphfqeqozcnabmtedffvzwbgbzbfydiyaevoqtfmzxaujdydtjftapkpdhnbmrylcibzuqqynvnsihmyx" +
                "dcrfftkuoymzoxpnashaderlosnkxbhamkkxfhwjsyehkmblhppbyspmcwuoguptliashefdklokjpggfiixozsrlwme" +
                "ksmzdcvipgkwxwynzsvxnqtchgwwadqybkguscfyrbyxudzrxacoplmcqcsmkraimfwbauvytkxdnglwfuvehpxd"));
    }
}
