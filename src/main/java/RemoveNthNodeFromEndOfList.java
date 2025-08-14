import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveNthNodeFromEndOfList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public int[] toArray() {
            ListNode temp = this;
            List<Integer> result = new ArrayList<>();
            while (temp != null) {
                result.add(temp.val);
                temp = temp.next;
            }
            return result.stream().mapToInt(Integer::intValue).toArray();
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        if (first == null) {
            return head.next;
        }
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return head;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList sol = new RemoveNthNodeFromEndOfList();
        ListNode head;
        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(Arrays.toString(sol.removeNthFromEnd(head, 2).toArray()));
        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(Arrays.toString(sol.removeNthFromEnd(head, 5).toArray()));
        head = new ListNode(1);
        System.out.println(sol.removeNthFromEnd(head, 1) == null);
    }
}
