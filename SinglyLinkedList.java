import java.util.Random;
import java.util.Scanner;
public class SinglyLinkedList {
    public static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head = null;
    public static Node tail = null;
    public static int size = 0;
    /* head and tail are made static because these are unique and can be only one in a linked list. Let us now implement the various methods of a singly linked list */
    public static void insertBegin(int data) {
        size++;
        if(head == null) {
            head = tail = new Node(data);
            return;
        }
        Node temp = new Node(data);
        temp.next = head;
        head = temp;
    }
    public static void insertEnd(int data) {
        size++;
        if(tail == null) {
            head = tail = new Node(data);
            return;
        }
        Node temp = new Node(data);
        tail.next = temp;
        tail = temp;
    }
    public static boolean insertPos(int data, int pos) {
        int totalNodes = size;
        if(pos<0 || pos > totalNodes) return false;
        else if(pos == 0) {
            insertBegin(data);
            return true;
        } else if(pos == totalNodes) {
            insertEnd(data);
            return true;
        }
        size++;
        Node toInsert = new Node(data);
        Node temp = head;
        for(int i=0; i<pos-1; i++) temp = temp.next;
        toInsert.next = temp.next;
        temp.next = toInsert;
        return true;
    }
    public static void insert() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the data to insert: ");
        int data = sc.nextInt();
        System.out.print("1. Insert at begin\n2. Insert at end\n3. Insert at any position\nEnter your choice: ");
        int ch = sc.nextInt();
        switch(ch) {
            case 1:
                insertBegin(data);
                System.out.println(data + " is inserted successfully!");
                break;
            case 2:
                insertEnd(data);
                System.out.println(data + " is inserted successfully!");
                break;
            case 3:
                System.out.print("Enter the position: ");
                if(!insertPos(data, sc.nextInt())) System.out.println("Invalid position!");
                else System.out.println(data + " is inserted successfully!");
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
    public static int removeBegin() {
        int data = -1;
        if(head == null) return data;
        else if(head.next == null) {
            data = head.data;
            head = tail = null;
        }
        else {
            data = head.data;
            head = head.next;
        }
        size--;
        return data;
    }
    public static int removeEnd() {
        int data = -1;
        if(head == null) return data;
        else if(head.next == null) {
            data = head.data;
            head = tail = null;
        }
        else {
            Node temp = head;
            while(temp.next != tail) temp = temp.next;
            data = tail.data;
            temp.next = null;
            tail = temp;
        }
        size--;
        return data;
    }
    public static int removePosByPos(int pos) {
        int totalNodes = size;
        if(head == null) return -1;
        if(pos < 0 || pos > totalNodes-1) return -1;
        if(pos == 0) return removeBegin();
        else if(pos == totalNodes-1) return removeEnd();
        else {
            Node temp = head;
            int data = -1;
            for(int i=0; i<pos-1; i++) temp = temp.next;
            data = temp.next.data;
            temp.next = temp.next.next;
            size--;
            return data;
        }
    }
    public static void remove() {
        Scanner sc = new Scanner(System.in);
        System.out.print("1. Remove from begin\n2. Remove from end\n3. Remove from any position\nEnter your choice: ");
        int ch = sc.nextInt(), res;
        switch(ch) {
            case 1:
                res = removeBegin();
                if(res != -1) System.out.println(res + " is removed successfully!");
                else System.out.println("Linked list is empty!");
                break;
            case 2:
                res = removeEnd();
                if(res != -1) System.out.println(res + " is removed successfully!");
                else System.out.println("Linked list is empty!");
                break;
            case 3:
                System.out.print("1. Delete by position\n2. Delete by value\nEnter your choice: ");
                int dCh = sc.nextInt();
                if(dCh == 1) {
                    System.out.print("Enter the position: ");
                    res = removePosByPos(sc.nextInt());
                    if(res == -1) System.out.println("Invalid position!");
                    else System.out.println(res + " is removed successfully!");
                    break;
                } else if(dCh == 2) {
                    System.out.print("Enter the value: ");
                    int val = sc.nextInt();
                    int searchResult = search(val);
                    if(searchResult == -1) System.out.println("Node with data " + val + " is not found!");
                    else {
                        res = removePosByPos(searchResult);
                        System.out.println(res + " is removed successfully!");
                    }
                } else System.out.println("Invalid choice!");
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
    /* public static int recSearch(Node temp, int key, int idx) {
        if(temp == null) return -1;
        else if(temp.data == key) return idx;
        else return recSearch(temp.next, key, idx+1);
    } */
    public static int search(int key) {
        Node temp = head;
        int nodeCount = 0;
        while(temp != null) {
            if(temp.data == key) return nodeCount;
            temp = temp.next;
            nodeCount++;
        }
        return -1;
    }
    public static void display() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
    public static int getNode(int index) {
        if(index < 0 || index > size-1) return -1;
        Node temp = head;
        int count = 0;
        while(count <= index-1 && temp != null) {
            count++;
            temp = temp.next;
        }
        return temp.data;
    }
    public static void reverseList() {
        if(head == null || head.next == null) return;
        Node currNode = tail = head, prevNode = null, nextNode = null;
        while(currNode != null) {
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        head = prevNode;
    }
    public static boolean checkCycle() {
        if(head == null) return false;
        Node slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
    public static void removeCycle() {
        if(head == null) return;
        Node slow = head, fast = head;
        boolean isCycle = false;
        while(fast != null && fast.next != null) {
            /* loop condition is for non-cyclic linked lists */
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                isCycle = true;
                break;
            }
        }
        if(!isCycle) return;
        Node prevNode = null;
        slow = head;
        /* checking for a special condition where slow and fast meet at head itself */
        if(slow == fast) {
            /* It is a cycle that definitely joins at head */
            while(fast.next != slow)
                fast = fast.next;
            fast.next = null;
            return;
        }
        while(slow != fast) {
            slow = slow.next;
            prevNode = fast;
            fast = fast.next;
        }
        prevNode.next = null;
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
        /* find the middle of the node, if total nodes is even, middle should be the last node of the first half for proper distribution */
        Node mid = findMid(head);
        Node rightHalfHead = mid.next;
        mid.next = null;
        rightHalfHead = reverse(rightHalfHead);
        head = mergeList(head, rightHalfHead);
        return head;
    }




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isContinue = true;
        while(isContinue) {
            System.out.print("*----- MENU -----*\n1. Insert\n2. Remove\n3. Search\n4. Display\n5. Create new list\n6. Count nodes\n7. Get ith node\n8. Reverse list\n9. Exit\nEnter your choice: ");
            int ch = sc.nextInt();
            switch(ch) {
                case 1:
                    insert();
                    break;
                case 2:
                    remove();
                    break;
                case 3:
                    Node temp = head;
                    System.out.print("Enter the data you want to search: ");
                    int key = sc.nextInt();
                    int res = search(key);
                    if(res != -1)
                        System.out.println(key + " found at index " + res + " in the linked list!");
                    else
                        System.out.println(key + " is not found in the linked list!");
                    break;
                case 4:
                    display();
                    break;
                case 5:
                    head = tail = null;
                    System.out.println("New list created successfully!");
                    break;
                case 6:
                    System.out.println("Total nodes: " + size);
                    break;
                case 7:
                    if(head == null) {
                        System.out.println("List is empty!");
                        break;
                    }
                    System.out.print("Enter the index of the node you want to fetch: ");
                    int ans = getNode(sc.nextInt());
                    if(ans != -1)
                        System.out.println("Fetched node has data " + ans);
                    else
                        System.out.println("Invalid index!");
                    break;
                case 8:
                    if(head == null) System.out.println("List is empty!");
                    else {
                        reverseList();
                        System.out.println("List is reversed!");
                    }
                    break;
                case 9:
                    isContinue = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        sc.close();
    }
}
/* public class LeetCode142 {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode slow = head, fast = head;
        boolean isCycle = false;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                isCycle = true;
                break;
            }
        }
        if(!isCycle) return null;
        slow = head;
        ListNode prev = null;
        if(slow == fast) {
            while(fast.next != slow)
                fast = fast.next;
            fast.next = null;
            return head;
        }
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
} */
