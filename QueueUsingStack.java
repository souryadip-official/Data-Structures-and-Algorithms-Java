import java.util.Scanner;
import java.util.Stack;
public class QueueUsingStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        boolean isContinue = true;
        while(isContinue) {
            System.out.print("*-----MENU-----*\n1-> Enqueue\n2-> Dequeue\n3-> Peek\n4-> Display Queue\n5-> Exit\nEnter your choice: ");
            int ch = sc.nextInt();
            switch(ch) {
                case 1:
                    System.out.print("Enter data to enqueue: ");
                    int data = sc.nextInt();
                    if(!s1.isEmpty()) {
                        while(!s1.isEmpty()) s2.push(s1.pop());
                        s1.push(data);
                        while(!s2.isEmpty()) s1.push(s2.pop());
                    } else s1.push(data);
                    System.out.println(data + " is enqueued successfully!");
                    break;
                case 2:
                    if(!s1.isEmpty()) System.out.println(s1.pop() + " is dequeued successfully!");
                    else System.out.println("Queue is empty!");
                    break;
                case 3:
                    if(!s1.isEmpty()) System.out.println("Peek result: " + s1.peek());
                    break;
                case 4:
                    if(s1.isEmpty()) System.out.println("[]");
                    else {
                        System.out.print("Queue status: [ ");
                        for(int i=s1.size()-1; i>=0; i--)
                            System.out.print(s1.get(i) + " ");
                        System.out.println("]");
                    }
                    break;
                case 5:
                    isContinue = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
