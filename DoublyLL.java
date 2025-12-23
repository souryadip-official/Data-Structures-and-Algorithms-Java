public class DoublyLL {
    public static class Node {
        Node prev;
        int data;
        Node next;

        Node(int data) {
            this.prev = null;
            this.data = data;
            this.next = null;
        }
    }

    public static Node head = null;
    public static Node tail = null;
    public static int size = 0;

    public void addAtHead(int data) {
        size++;
        if (head == null) {
            head = tail = new Node(data);
            return;
        }
        Node newNode = new Node(data);
        head.prev = newNode;
        newNode.next = head;
        head = newNode;
    }

    public void addAtTail(int data) {
        size++;
        if (tail == null) {
            head = tail = new Node(data);
            return;
        }
        Node newNode = new Node(data);
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void removeFirst() {
        if (head == null) return;
        size--;
        if (head.next == null) {
            head = tail = null;
            return;
        }
        head = head.next;
        head.prev = null;
    }

    public void removeLast() {
        if (tail == null) return;
        size--;
        if (head == tail) {
            head = tail = null;
            return;
        }
        tail = tail.prev;
        tail.next = null;
    }

    public Node reverse() {
        if (head == null || head.next == null) return head;
        Node prev = null, curr = tail = head, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
    public static void main(String[] args) {
        DoublyLL d = new DoublyLL();
        System.out.println("Inserts: ");
        d.display();
        d.addAtTail(219);
        d.display();
        d.addAtHead(5);
        d.display();
        d.addAtHead(21);
        d.display();
        d.addAtHead(56);
        d.display();
        d.addAtTail(100);
        d.display();
        d.addAtTail(200);
        d.display();
        d.addAtTail(500);
        d.display();
        System.out.println("Deletes: ");
        d.removeFirst();
        d.display();
        d.removeFirst();
        d.display();
        d.removeLast();
        d.display();
        d.removeLast();
        d.display();
        d.removeLast();
        d.display(); 
        head = d.reverse();
        d.display();
        d.addAtTail(-5);
        d.addAtHead(-100);
        d.display();
        System.out.println(size);
    }
}
