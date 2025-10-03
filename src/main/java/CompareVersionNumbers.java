import java.util.ArrayList;
import java.util.List;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        List<Integer> v1List = new ArrayList<>();
        List<Integer> v2List = new ArrayList<>();
        for (String num : version1.split("\\.")) {
            v1List.add(Integer.parseInt(num));
        }
        for (String num : version2.split("\\.")) {
            v2List.add(Integer.parseInt(num));
        }
        while (v1List.size() < v2List.size()) {
            v1List.add(0);
        }
        while (v2List.size() < v1List.size()) {
            v2List.add(0);
        }
        for (int i = 0; i < v1List.size(); i++) {
            if (v1List.get(i) < v2List.get(i)) {
                return -1;
            } else if (v1List.get(i) > v2List.get(i)) {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        CompareVersionNumbers sol = new CompareVersionNumbers();
        System.out.println(sol.compareVersion("1.2", "1.10") == -1);
        System.out.println(sol.compareVersion("1.01", "1.001") == 0);
        System.out.println(sol.compareVersion("1.0", "1.0.0.0") == 0);
        System.out.println(sol.compareVersion("1.0.1.1", "1.0.0.0") == 1);
    }
}
