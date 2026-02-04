public class DeleteTheMiddleNodeOfALinkedList {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static int getCount(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
    public ListNode deleteMiddle1(ListNode head) {
        if (head == null || head.next == null) return null;
        int count = getCount(head), idx = 0;
        ListNode prev = null, temp = head;
        while (idx < (count/2)) {
            prev = temp;
            temp = temp.next;
            idx++;
        }
        /* By the end of the above loop, we are standing at the node to be deleted */
        prev.next = temp.next;
        return head;
    }
    public ListNode deleteMiddle(ListNode head) {
        /* Another approach by which we can solve this problem is by considering the fast and slow pointer approach. Fast pointer travels two nodes at a time while slow moves one node at a time. So by the point fast reaches the end, slow covers half the path thereby standing at the middle node */
        if (head == null || head.next == null) return null;
        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return head;
    }
}
