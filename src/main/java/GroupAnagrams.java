import javax.swing.*;
import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strings) {
        Map<String, List<String>> anagrams = new HashMap<>();
        for (String s : strings) {
            char[] sortedArray = s.toCharArray();
            Arrays.sort(sortedArray);
            String sorted = Arrays.toString(sortedArray);
            if (!anagrams.containsKey(sorted)) {
                anagrams.put(sorted, new ArrayList<>());
            }
            anagrams.get(sorted).add(s);
        }
        return new ArrayList<>(anagrams.values());
    }

    public static void main(String[] args) {
        GroupAnagrams sol = new GroupAnagrams();
        String[] test1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] test2 = {""};
        String[] test3 = {"a"};
        System.out.println(sol.groupAnagrams(test1));
        System.out.println(sol.groupAnagrams(test2));
        System.out.println(sol.groupAnagrams(test3));
    }
}
