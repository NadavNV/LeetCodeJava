import java.util.ArrayList;
import java.util.List;

public class ListNode {
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
