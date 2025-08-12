import java.util.Objects;

public class IntegerToRoman {
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        int[] numbers = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strings = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < numbers.length; i++) {
            while (num >= numbers[i]) {
                result.append(strings[i]);
                num -= numbers[i];
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman test = new IntegerToRoman();
        System.out.println(Objects.equals(test.intToRoman(3749), "MMMDCCXLIX"));
        System.out.println(Objects.equals(test.intToRoman(58), "LVIII"));
        System.out.println(Objects.equals(test.intToRoman(1994), "MCMXCIV"));
    }
}
