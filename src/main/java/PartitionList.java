import java.util.Arrays;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode lesserHead = null, lesserTail = null, greaterHead = null, greaterTail = null;
        while (head != null) {
            if (head.val < x) {
                if (lesserHead == null) {
                    lesserHead = new ListNode(head.val);
                    lesserTail = lesserHead;
                } else {
                    lesserTail.next = new ListNode(head.val);
                    lesserTail = lesserTail.next;
                }
            } else {
                if (greaterHead == null) {
                    greaterHead = new ListNode(head.val);
                    greaterTail = greaterHead;
                } else {
                    greaterTail.next = new ListNode(head.val);
                    greaterTail = greaterTail.next;
                }
            }
            head = head.next;
        }
        if (lesserHead == null) {
            return greaterHead;
        } else {
            lesserTail.next = greaterHead;
            return lesserHead;
        }
    }

    public static void main(String[] args) {
        PartitionList sol = new PartitionList();
        ListNode test = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2,
                new ListNode(5, new ListNode(2))))));
        System.out.println(Arrays.equals(sol.partition(test, 3).toArray(), new int[]{1, 2, 2, 4, 3, 5}));
    }
}
