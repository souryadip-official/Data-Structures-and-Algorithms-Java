public class Stack02 {
    public static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static class Stack {
        public Node head = null;
        public Node tail = null;
        public boolean isEmpty() {
            return (head == null);
        }
        public void push(int data) {
            Node newNode = new Node(data);
            if(isEmpty()) head = tail = newNode;
            else {
                newNode.next = head;
                head = newNode;
            }
            System.out.println(data + " is pushed successfully!");
        }
        // not a conventional operation but asked in many of an interviews
        public void pushAtBottom(int data) {
            if(this.head == null) {
                this.push(data);
                return;
            }
            int val = this.pop();
            pushAtBottom(data);
            this.push(val);
        }
        /* public void pushAtBottom(int data) {
            Node newNode = new Node(data);
            if(tail == null) head = tail = newNode;
            else {
                tail.next = newNode;
                tail = newNode;
            }
            System.out.println(data + " is pushed at the bottom successfully!");
        } */
        public int pop() {
            if(isEmpty()) {
                System.out.println("Stack underflow!");
                return -1;
            }
            int res = head.data;
            head = head.next;
            System.out.println(res + " is popped successfully!");
            return res;
        }
        public void peek() {
            if(isEmpty()) {
                System.out.println("Stack is empty!");
                return;
            }
            System.out.println("Topmost element is: " + head.data);
        }
        public void display() {
            if(isEmpty()) {
                System.out.println("Stack is empty!");
                return;
            }
            Node temp = head;
            while(temp != null) {
                System.out.println(" |\t" + temp.data + "\t| " + ((temp == head) ? " <-- TOP" : ""));
                temp = temp.next;
            }
            System.out.println(" -------- ");
        }
    }
    public static void main(String[] args) {
        Stack s = new Stack();
        s.pushAtBottom(24);
        s.push(5);
        s.pushAtBottom(6);
        s.peek();
        s.display();
        s.push(25);
        s.push(39);
        s.display();
        s.pushAtBottom(69);
        s.display();
        s.pop();
    }
}
