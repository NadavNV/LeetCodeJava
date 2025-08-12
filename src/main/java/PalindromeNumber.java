public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int temp = x;
        int rev = 0;
        while (temp > 0) {
            int digit = temp % 10;
            temp /= 10;
            rev = rev * 10 + digit;
        }
        return rev == x;
    }

    public static void main(String[] args) {
        PalindromeNumber test = new PalindromeNumber();
        System.out.println(test.isPalindrome(121));
        System.out.println(!test.isPalindrome(-121));
        System.out.println(!test.isPalindrome(10));
    }
}
