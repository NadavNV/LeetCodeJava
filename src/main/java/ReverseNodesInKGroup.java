import java.util.Arrays;

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        ListNode start = null;
        ListNode previous = null;
        int count = 1;
        ListNode current = head, first = head;
        while (current != null) {
            if (count == k) {
                ListNode next = current.next;
                ListNode tail = first;
                current.next = null;
                if (previous == null) {
                    start = reverseList(first);
                } else {
                    previous.next = reverseList(first);
                }
                tail.next = next;
                previous = tail;
                current = next;
                first = next;
                count = 1;
            } else {
                current = current.next;
                count++;
            }
        }
        return start;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode previous = head;
        ListNode current = head.next;
        previous.next = null;
        while (current.next != null) {
            ListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        current.next = previous;
        return current;
    }

    public static void main(String[] args) {
        ReverseNodesInKGroup sol = new ReverseNodesInKGroup();
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode list2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode list3 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        ListNode list4 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        System.out.println(Arrays.equals(sol.reverseKGroup(list1, 2).toArray(), new int[]{2, 1, 4, 3, 5}));
        System.out.println(Arrays.equals(sol.reverseKGroup(list2, 3).toArray(), new int[]{3, 2, 1, 4, 5}));
        System.out.println(Arrays.equals(sol.reverseKGroup(list3, 2).toArray(), new int[]{2, 1, 4, 3, 6, 5}));
        System.out.println(Arrays.equals(sol.reverseKGroup(list4, 3).toArray(), new int[]{3, 2, 1, 6, 5, 4}));
    }
}
