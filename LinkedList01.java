import java.util.Scanner;
class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class LinkedList01 {
    public static void display(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = null, tail = null;
        boolean isContinue = true;
        while(isContinue) {
            System.out.print("1. Insert at begin:\n2: Insert at end\n3: Display\n4: Exit\nEnter your choice: ");
            int ch = sc.nextInt();
            int d;
            Node temp;
            switch(ch) {
                case 1:
                    System.out.print("Enter data: ");
                    d = sc.nextInt();
                    temp = new Node(d);
                    if(head == null) head = tail = temp;
                    else {
                        temp.next = head;
                        head = temp;
                    }
                    System.out.println(d + " inserted successfully!");
                    break;
                case 2:
                    System.out.print("Enter the data: ");
                    d = sc.nextInt();
                    temp = new Node(d);
                    if(tail == null) head = tail = temp;
                    else {
                        tail.next = temp;
                        tail = temp;
                    }
                    System.out.println(d + " inserted successfully!");
                    break;
                case 3:
                    display(head);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    isContinue = false;
                    break;
            }
        }
    }
}