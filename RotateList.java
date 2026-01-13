public class RotateList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode rotateRight1(ListNode head, int k) {
        if (k == 0) return head; /* No shift */
        if (head == null) return head; /* Zero node LL */
        ListNode tail = null, temp = head, prev = null;
        int totalNodes = 0;
        while (temp != null) {
            prev = tail;
            tail = temp;
            temp = temp.next;
            totalNodes++;
        }
        if (head == tail) return head; /* One node LL */
        k = k % totalNodes; /* Because if there are 5 nodes in LL, after 5 shift, we get the same list again. So actually we required 5 % 5 = 0 shifts */
        for (int i=1; i<=k; i++) {
            prev.next = null;
            tail.next = head;
            head = tail;
            tail = prev;
            temp = head;
            while (temp != tail) {
                prev = temp;
                temp = temp.next;
            }
            temp = null;
        }
        return head;
    }
    public ListNode rotateRightOptimized(ListNode head, int k) {
        if (k == 0) return head;
        if (head == null) return head;
        ListNode tail = null, temp = head, prev = null;
        int totalNodes = 0;
        while (temp != null) {
            prev = tail;
            tail = temp;
            temp = temp.next;
            totalNodes++;
        }
        if (head == tail) return head;
        tail.next = head;
        k = k % totalNodes;
        int target = totalNodes - k;
        int count = 1;
        temp = head;
        while (count < target) {
            temp = temp.next;
            count++;
        }
        head = temp.next;
        temp.next = null;
        return head;
    }
}
