public class DeleteLLNodeWithoutHead {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public void deleteNode(ListNode node) {
        /* We will swap the value of this node, with the adjacent node and delete the adjacent node */
        int temp = node.next.val;
        node.next.val = node.val;
        node.val = temp;

        /* If this is the second-last node, then marking this as the last node */
        if (node.next.next == null) {
            node.next = null;
            return;
        } else {
            /* else linking the current node with the node next to next of the curr node */
            node.next = node.next.next;
            return;
        }
    }
}
