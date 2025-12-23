/*
We have a linked list and two keys in it, swap nodes for two given keys. Nodes should be
swapped by changing links. Swapping data of nodes may be expensive in many situations when
data contains many fields. It may be assumed that all keys in the linked list are distinct.
Sample Input 1 : 1->2->3->4, x = 2, y = 4
Sample Output 1 : 1->4->3->2 */

class SwapByNode {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static int index = -1;
    public static ListNode prev = null;

    public static int count(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while(temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
    public static ListNode getNodeByVal(ListNode head, int val) {
        ListNode temp = head;
        while(temp != null) {
            index++;
            if(temp.val == val) {
                return temp;
            }
            prev = temp;
            temp = temp.next;
        }
        return null;
    }

    public static ListNode insertAtHead(ListNode head, ListNode newNode) {
        if(head == null) {
            head = newNode;
            return head;
        }
        newNode.next = head;
        head = newNode;
        return head;
    }
    public static ListNode insertAtTail(ListNode head, ListNode newNode) {
        if(head == null) {
            head = newNode;
            return head;
        }
        ListNode temp = head;
        while(temp.next != null) temp = temp.next;
        temp.next = newNode;
        return head;
    }
    public static ListNode insertAtPos(ListNode head, ListNode newNode, int pos) {
        if(pos == 0) return insertAtHead(head, newNode);
        int totNodes = count(head);
        if(pos == totNodes) return insertAtTail(head, newNode);
        ListNode temp = head;
        for(int i=0; i<pos-1; i++) temp = temp.next;
        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }
    public static ListNode swapNodes(ListNode head, int x, int y) {
        // fetching the first node
        if(x == y || head == null || head.next == null) return head;
        ListNode node1 = getNodeByVal(head, x);
        if(node1 == null) return head;
        int idx_node1 = index;
        ListNode prevOfnode1 = prev;
        if(prevOfnode1 != null) {
            prevOfnode1.next = node1.next;
            node1.next = null;
        } else {
            head = node1.next;
            node1.next = null;
        }

        SwapByNode.index = -1; // reset
        SwapByNode.prev = null; // reset

        // fetching the second node
        ListNode node2 = getNodeByVal(head, y);
        if(node2 == null) return head;
        int idx_node2 = index;
        ListNode prevOfnode2 = prev;
        if(prevOfnode2 != null) {
            prevOfnode2.next = node2.next;
            node2.next = null;
        } else {
            head = node2.next;
            node2.next = null;
        }
        if(idx_node1 < idx_node2) {
            head = insertAtPos(head, node2, idx_node1);
            head = insertAtPos(head, node1, idx_node2);
            return head;
        } else {
            head = insertAtPos(head, node1, idx_node2);
            head = insertAtPos(head, node2, idx_node1);
            return head;
        }
    }

    public static void display(ListNode head) {
        ListNode temp = head;
        while(temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
    public static void main(String[] args) {
        ListNode head = null;
        head = insertAtHead(head, new ListNode(5));
        head = insertAtTail(head, new ListNode(20));
        head = insertAtHead(head, new ListNode(1));
        head = insertAtTail(head, new ListNode(26));
        display(head);
        head = swapNodes(head, 20, 1);
        display(head);
    }
}