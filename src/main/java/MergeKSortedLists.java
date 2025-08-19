import java.util.Arrays;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return mergeSort(lists, 0, lists.length - 1);
    }

    private ListNode mergeSort(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        int mid = (start + end) / 2;
        ListNode left = mergeSort(lists, start, mid);
        ListNode right = mergeSort(lists, mid + 1, end);
        return mergeTwoLists(left, right);
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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
        MergeKSortedLists sol = new MergeKSortedLists();
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(2, new ListNode(6));
        System.out.println(Arrays.toString(sol.mergeKLists(new ListNode[]{l1, l2, l3}).toArray()));
    }
}
