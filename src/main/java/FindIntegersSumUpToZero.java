import java.util.ArrayList;
import java.util.List;

public class FindIntegersSumUpToZero {
    public int[] sumZero(int n) {
        int[] result = new int[n];
        int left = 0, right = n - 1, i = 1;
        while (left < right) {
            result[left++] = i;
            result[right--] = -i;
            i++;
        }
        if (left == right) {
            result[left] = 0;
        }
        return result;
    }
}
