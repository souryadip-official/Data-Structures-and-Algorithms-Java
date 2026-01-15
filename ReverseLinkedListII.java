import java.util.ArrayList;
public class ReverseLinkedListII {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return null;
        if (left == right) return head;
        ArrayList<Integer> rev = new ArrayList<>();
        int index = 1;
        ListNode curr = head;
        while (curr != null) {
            if (left <= index && index <= right) {
                rev.add(curr.val);
            }
            index++;
            curr = curr.next;
        }
        /* Reversal steps */
        curr = head;
        int revIndx = rev.size()-1;
        index = 1;
        while (curr != null) {
            if (left <= index && index <= right) {
                curr.val = rev.get(revIndx--);
            }
            index++;
            curr = curr.next;
        }
        return head;
    }
}

