public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode current = head;
        while (current != null) {
            while (current.next != null && current.val == current.next.val) {
                current.next = current.next.next;
            }
            current = current.next;
        }
        return head;
    }
}
