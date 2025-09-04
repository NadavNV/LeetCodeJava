import java.util.Arrays;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int n = 1;
        ListNode start = head;
        while (head.next != null) {
            n++;
            head = head.next;
        }
        head.next = start;
        k %= n;
        for (int i = 0; i < n - k; i++) {
            start = start.next;
        }
        while (head.next != start) {
            head = head.next;
        }
        head.next = null;
        return start;
    }

    public static void main(String[] args) {
        RotateList sol = new RotateList();
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode list2 = new ListNode(0, new ListNode(1, new ListNode(2)));
        int[] expected1 = {4, 5, 1, 2, 3};
        int[] expected2 = {2, 0, 1};
        System.out.println(Arrays.equals(sol.rotateRight(list1, 2).toArray(), expected1));
        System.out.println(Arrays.equals(sol.rotateRight(list2, 4).toArray(), expected2));
    }
}
