public class RemoveNAfterM {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    public static ListNode add(ListNode head, ListNode newNode) {
        if(head == null) {
            head = newNode;
            return head;
        }
        newNode.next = head;
        head = newNode;
        return head;
    }
    public static ListNode delete(ListNode head, int m, int n) {
        ListNode temp = head;
        int skip = m;

        while(temp != null) {
            while(skip-1 > 0) {
                if(temp == null) return head;
                temp = temp.next;
                skip--;
            }
            if(temp == null) return head;
            ListNode start = temp.next;
            // now we have to delete the n nodes
            for(int i=0; i<n; i++) {
                if(start == null) {
                    System.out.println("We ended up having insufficient nodes! Deleted as far as the algorithm could.");
                    return head;
                }
                start = start.next;
            }
            temp.next = start;
            temp = temp.next;
            skip = m;
        }
        return head;
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
        for(int i=25; i>=1; i--) {
            head = add(head, new ListNode(i));
        }
        display(head);
        head = delete(head, 4, 2);
        display(head);
    }
}
