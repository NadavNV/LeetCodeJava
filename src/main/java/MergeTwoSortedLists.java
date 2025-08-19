import java.util.Arrays;
import java.util.Objects;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode start = new ListNode();
        ListNode node = start;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }
        while (list1 != null) {
            node.next = list1;
            list1 = list1.next;
            node = node.next;
        }
        while (list2 != null) {
            node.next = list2;
            list2 = list2.next;
            node = node.next;
        }
        return start.next;
    }

    public static void main(String[] args) {
        MergeTwoSortedLists sol = new MergeTwoSortedLists();
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        System.out.println(Arrays.equals(sol.mergeTwoLists(l1, l2).toArray(), new int[]{1, 1, 2, 3, 4, 4}));
        System.out.println(sol.mergeTwoLists(null, null) == null);
        System.out.println(Arrays.equals(sol.mergeTwoLists(null, new ListNode(0)).toArray(), new int[]{0}));
    }
}
