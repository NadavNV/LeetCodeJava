import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public List<Integer> grayCode(int n) {
        if (n == 0) return List.of(0);
        if (n == 1) return List.of(0, 1);
        List<String> previous = new ArrayList<>();
        for (int x : grayCode(n - 1)) {
            StringBuilder binaryString = new StringBuilder(Integer.toBinaryString(x));
            while (binaryString.length() < n - 1) {
                binaryString.insert(0, "0");
            }
            previous.add(binaryString.toString());
        }
        List<String> reversed = previous.reversed();
        previous.addAll(reversed.stream()
                .map(s -> "1" + s)
                .toList());
        return previous.stream().map(s -> Integer.parseInt(s, 2)).toList();
    }

    public static void main(String[] args) {
        GrayCode sol = new GrayCode();
        System.out.println(sol.grayCode(2).equals(List.of(0, 1, 3, 2)));
    }
}
