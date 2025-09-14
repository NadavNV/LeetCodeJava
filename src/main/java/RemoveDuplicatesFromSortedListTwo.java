import java.util.Arrays;

public class RemoveDuplicatesFromSortedListTwo {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode start = head;
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            boolean isDuplicate = false;
            while (current.next != null && current.val == current.next.val) {
                isDuplicate = true;
                current = current.next;
            }
            if (isDuplicate) {
                if (prev == null) {
                    start = current.next;
                } else {
                    prev.next = current.next;
                }
                current = current.next;
            } else {
                prev = current;
                current = current.next;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedListTwo sol = new RemoveDuplicatesFromSortedListTwo();
        ListNode[] test = new ListNode[4];
        test[0] = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
        test[1] = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3)))));
        test[2] = new ListNode(1, new ListNode(1));
        test[3] = new ListNode(1, new ListNode(2, new ListNode(2)));
        int[][] expected = {
                {1, 2, 5},
                {2, 3},
                null,
                {1}
        };
        for (int i = 0; i < test.length; i++) {
            ListNode result = sol.deleteDuplicates(test[i]);
            if (result != null) {
                System.out.println(Arrays.equals(result.toArray(), expected[i]));
            } else {
                System.out.println(expected[i] == null);
            }
        }
    }
}
