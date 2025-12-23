import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
public class StackUsingDeque {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("*-----MENU-----*\n1-> Stack\n2-> Queue\n3-> Exit\nEnter your choice: ");
        int dsCh = sc.nextInt();
        if(dsCh == 1) {
            Deque<Integer> stack = new LinkedList<>();
            boolean isContinue = true;
            while(isContinue) {
                System.out.print("*-----STACK MENU-----*\n1-> Push\n2-> Pop\n3-> Peek\n4-> Display Stack\n5-> Exit\nEnter your choice: ");
                int ch = sc.nextInt();
                switch(ch) {
                    case 1:
                        System.out.print("Enter data to push: ");
                        int data = sc.nextInt();
                        stack.addLast(data);
                        System.out.println(data + " is pushed successfully!");
                        break;
                    case 2:
                        if(!stack.isEmpty()) System.out.println(stack.removeLast() + " is popped successfully!");
                        else System.out.println("Stack underflow!");
                        break;
                    case 3:
                        if(!stack.isEmpty()) System.out.println("Peek result: " + stack.getLast());
                        else System.out.println("Stack is empty!");
                        break;
                    case 4:
                        System.out.println("Stack status: " + stack);
                        break;
                    case 5:
                        isContinue = false;
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            }
        } else if(dsCh == 2) {
            Deque<Integer> queue = new LinkedList<>();
            boolean isContinue = true;
            while(isContinue) {
                System.out.print("*-----QUEUE MENU-----*\n1-> Enqueue\n2-> Dequeue\n3-> Peek\n4-> Display Queue\n5-> Exit\nEnter your choice: ");
                int ch = sc.nextInt();
                switch(ch) {
                    case 1:
                        System.out.print("Enter data to enqueue: ");
                        int data = sc.nextInt();
                        queue.addLast(data);
                        System.out.println(data + " is enqueued successfully!");
                        break;
                    case 2:
                        if(!queue.isEmpty()) System.out.println(queue.removeFirst() + " is dequeued successfully!");
                        else System.out.println("Queue is empty!");
                        break;
                    case 3:
                        if(!queue.isEmpty()) System.out.println("Peek result: " + queue.getFirst());
                        else System.out.println("Queue is empty!");
                        break;
                    case 4:
                        System.out.println("Queue status: " + queue);
                        break;
                    case 5:
                        isContinue = false;
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            }
        } else {
            System.out.println("Exiting...");
            return;
        }
        sc.close();
    }
}
