public class LeetCode143 {
    static class Node {
        int val;
        Node next;
        Node(int val) { this.val = val; this.next = null; }
    }

    public static Node findMid(Node head) {
        if(head == null || head.next == null) return head;
        Node slow = head, fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static Node reverse(Node head) {
        if(head == null || head.next == null) return head;
        Node prev = null, curr = head, next = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }
    public static Node mergeList(Node left, Node right) {
        if(left == null) return right;
        if(right == null) return left;
        Node zigzagList = null, temp = null;
        /* only for the first pass when zigzagList and temp is null */
        zigzagList = temp = left;
        left = left.next;
        temp.next = right;
        right = right.next;
        temp = temp.next;

        /* after the first pass */
        while(left != null && right != null) {
            temp.next = left;
            left = left.next;
            temp = temp.next;
            temp.next = right;
            right = right.next;
            temp = temp.next;
        }

        /* if the left half is yet to be finished */
        while(left != null) {
            temp.next = left;
            left = left.next;
            temp = temp.next;
        }

        /* if the right half is yet to be finished */
        while(right != null) {
            temp.next = right;
            right = right.next;
            temp = temp.next;
        }
        return zigzagList;
    }
    public static Node zigzag(Node head) {
        if(head == null || head.next == null) return head;
        /* we are required to find the middle of the linked list, if total nodes is even, middle should be the last node of the first half for proper distribution */
        Node mid = findMid(head);
        Node rightHalfHead = mid.next;
        mid.next = null;
        rightHalfHead = reverse(rightHalfHead);
        head = mergeList(head, rightHalfHead);
        return head;
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("NULL");
    }

    public static Node createList(int[] arr) {
        if (arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new Node(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[][] testCases = {{}, {1}, {1, 2}, {1, 2, 3}, {1, 2, 3, 4}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5, 6}, {1, 3, 5, 7, 8, 6, 4, 2}, {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150}, {5, 3, 9, 1, 4, 8, 6, 7, 2, 0, 1, 3, 5, 9}};
        for (int[] test : testCases) {
            System.out.println("Original:");
            Node head = createList(test);
            printList(head);
            head = zigzag(head);
            System.out.println("Zigzag:");
            printList(head);
            System.out.println("----------------------");
        }
    }
}