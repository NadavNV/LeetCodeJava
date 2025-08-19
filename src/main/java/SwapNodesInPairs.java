import java.util.Arrays;
import java.util.Objects;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head.next.next;
        ListNode start = head.next;
        start.next = head;
        head.next = swapPairs(temp);
        return start;
    }

    public static void main(String[] args) {
        SwapNodesInPairs sol = new SwapNodesInPairs();
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode list2 = new ListNode(1, new ListNode(2, new ListNode(3)));
        System.out.println(Arrays.equals(sol.swapPairs(list1).toArray(), new int[]{2, 1, 4, 3}));
        System.out.println(Arrays.equals(sol.swapPairs(list2).toArray(), new int[]{2, 1, 3}));
        System.out.println(sol.swapPairs(null) == null);
        System.out.println(Arrays.equals(sol.swapPairs(new ListNode(1)).toArray(), new int[]{1}));
    }
}
