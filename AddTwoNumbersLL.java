public class AddTwoNumbersLL {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1, temp2 = l2;
        ListNode head = null, tail = null; /* head and tail of the new linked list */
        int carry = 0, sum = 0;
        while (temp1 != null && temp2 != null) {
            int val1 = temp1.val;
            int val2 = temp2.val;
            temp1 = temp1.next;
            temp2 = temp2.next;
            sum = val1 + val2 + carry;
            if (sum >= 10) {
                sum = sum - 10;
                carry = 1;
            } else carry = 0;
            if (head == null)
                head = tail = new ListNode(sum);
            else {
                tail.next = new ListNode(sum);
                tail = tail.next;
            }
            sum = 0; /* sum is reset */
        }
        while (temp1 != null) {
            int val1 = temp1.val;
            temp1 = temp1.next;
            sum = val1 + carry;
            if (sum >= 10) {
                sum = sum - 10;
                carry = 1;
            } else carry = 0;
            if (head == null)
                head = tail = new ListNode(sum);
            else {
                tail.next = new ListNode(sum);
                tail = tail.next;
            }
            sum = 0;
        }
        while (temp2 != null) {
            int val2 = temp2.val;
            temp2 = temp2.next;
            sum = val2 + carry;
            if (sum >= 10) {
                sum = sum - 10;
                carry = 1;
            } else carry = 0;
            if (head == null)
                head = tail = new ListNode(sum);
            else {
                tail.next = new ListNode(sum);
                tail = tail.next;
            }
            sum = 0;
        }
        if (carry == 1) {
            if (head == null)
                head = tail = new ListNode(1);
            else {
                tail.next = new ListNode(1);
                tail = tail.next;
            }
        }
        return head;
    }
}