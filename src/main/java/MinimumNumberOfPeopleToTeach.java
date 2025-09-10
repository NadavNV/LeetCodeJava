import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumNumberOfPeopleToTeach {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Set<Integer> peopleCantCommunicate = new HashSet<>();
        for (int[] friendship : friendships) {
            Map<Integer, Integer> languagesKnown = new HashMap<>();
            boolean canCommunicate = false;
            for (int lan : languages[friendship[0] - 1]) {
                languagesKnown.put(lan, 1);
            }
            for (int lan : languages[friendship[1] - 1]) {
                if (languagesKnown.containsKey(lan)) {
                    canCommunicate = true;
                    break;
                }
            }
            if (!canCommunicate) {
                peopleCantCommunicate.add(friendship[0] - 1);
                peopleCantCommunicate.add(friendship[1] - 1);
            }
        }
        int macCount = 0;
        int[] countLanguages = new int[n + 1];
        for (int person : peopleCantCommunicate) {
            for (int lan : languages[person]) {
                countLanguages[lan]++;
                macCount = Math.max(macCount, countLanguages[lan]);
            }
        }
        return peopleCantCommunicate.size() - macCount;
    }

    public static void main(String[] args) {
        MinimumNumberOfPeopleToTeach sol = new MinimumNumberOfPeopleToTeach();
        System.out.println(sol.minimumTeachings(
                2,
                new int[][]{{1}, {2}, {1, 2}},
                new int[][]{{1, 2}, {1, 3}, {2, 3}}
        ) == 1);
        System.out.println(sol.minimumTeachings(
                3,
                new int[][]{{2}, {1, 3}, {1, 2}, {3}},
                new int[][]{{1, 4}, {1, 2}, {3, 4}, {2, 3}}
        ) == 2);
    }
}
