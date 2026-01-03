public class DuplicateRemovalInList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode deleteDuplicates(ListNode head) {
    if (head == null) return null;
    ListNode newHead = null, tail = null, temp = head;
    newHead = tail = head;
    temp = temp.next;
    while (temp != null) {
        if (temp.val == tail.val)
            temp = temp.next;
        else {
            tail.next = temp;
            tail = tail.next;
            temp = temp.next;
        }
    }
    tail.next = null;
    return newHead;
    }
}