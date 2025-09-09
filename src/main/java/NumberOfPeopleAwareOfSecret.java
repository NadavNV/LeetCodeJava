import java.util.Deque;
import java.util.LinkedList;

public class NumberOfPeopleAwareOfSecret {
    private static final int MODULU = (int) Math.pow(10, 9) + 7;

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        Deque<int[]> know = new LinkedList<>();
        Deque<int[]> share = new LinkedList<>();
        know.add(new int[]{1, 1});
        int knowCount = 1;
        int shareCount = 0;
        for (int day = 2; day <= n; day++) {
            if (!know.isEmpty() && know.peekFirst()[0] == day - delay) {
                int[] first = know.pollFirst();
                knowCount = (knowCount - first[1] + MODULU) % MODULU;
                shareCount = (shareCount + first[1]) % MODULU;
                share.add(first);
            }
            if (!share.isEmpty() && share.peekFirst()[0] == day - forget) {
                int[] first = share.pollFirst();
                shareCount = (shareCount - first[1] + MODULU) % MODULU;
            }
            if (!share.isEmpty()) {
                knowCount = (knowCount + shareCount) % MODULU;
                know.add(new int[]{day, shareCount});
            }
        }
        return (knowCount + shareCount) % MODULU;
    }

    public static void main(String[] args) {
        NumberOfPeopleAwareOfSecret sol = new NumberOfPeopleAwareOfSecret();
        System.out.println(sol.peopleAwareOfSecret(6, 2, 4) == 5);
        System.out.println(sol.peopleAwareOfSecret(4, 1, 3) == 6);
    }
}
