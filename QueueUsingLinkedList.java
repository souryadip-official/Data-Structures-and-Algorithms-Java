class QueueLL {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    Node head = null;
    Node tail = null;
    public boolean isEmpty() {
        return (head == null && tail == null);
    }
    public void enqueue(int data) {
        /* Enqueue in a queue is identical to insertAtEnd in a Singly Linked List */
        Node newNode = new Node(data);
        if(isEmpty()) head = tail = newNode;
        else {
            tail.next = newNode;
            tail = newNode;
        }
        System.out.println(data + " is enqueued successfully!");
    }
    public int dequeue() {
        /* Dequeue in a queue is identical to deleteAtHead in a Singly Linked List */
        if(isEmpty()) {
            System.out.println("Queue is empty!");
            return -99999;
        }
        int data = head.data;
        if(head.next == null)
            head = tail = null;
        else head = head.next;
        System.out.println(data + " is dequeued successfully!");
        return data;
    }
    public int peek() {
        if(isEmpty()) {
            System.out.println("Queue is empty!");
            return -99999;
        }
        System.out.println("Peek result: " + head.data);
        return head.data;
    }
    public int getFront() {
        if(!isEmpty()) return head.data;
        return -99999;
    }
    public int getRear() {
        if(!isEmpty()) return tail.data;
        return -99999;
    }
    public void display() {
        Node curr = head;
        while(curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("NULL");
    }
}
public class QueueUsingLinkedList {
    public static void main(String[] args) {
        QueueLL q = new QueueLL();
        for(int i=1; i<=5; i++) q.enqueue(i);
        q.display();
        for(int i=1; i<=3; i++) q.dequeue();
        q.display();
        for(int i=1; i<=2; i++) q.enqueue(9+i);
        q.display();
        q.dequeue();
        q.display();
        for(int i=1; i<=3; i++) q.enqueue(11+i);
        q.display();
        for(int i=0; i<=5; i++) q.dequeue();
        q.display();
        for(int i=1; i<=5; i++) q.enqueue(i);
        q.display();
    }
}
