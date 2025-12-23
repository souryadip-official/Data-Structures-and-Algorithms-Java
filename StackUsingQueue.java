import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Queue;

public class StackUsingQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        boolean isContinue = true;
        int top;
        while(isContinue) {
            System.out.print("*-----MENU-----*\n1-> Push\n2-> Pop\n3-> Peek\n4-> Display Stack\n5-> Exit\nEnter your choice: ");
            int ch = sc.nextInt();
            switch(ch) {
                case 1:
                    System.out.print("Enter data to push: ");
                    int data = sc.nextInt();
                    if(!q1.isEmpty()) q1.add(data);
                    else if(!q2.isEmpty()) q2.add(data);
                    else q1.add(data); /* by default */
                    System.out.println(data + " is pushed successfully!");
                    break;
                case 2:
                    top = -1;
                    if(!q1.isEmpty()) {
                        while(!q1.isEmpty()) {
                            top = q1.remove();
                            if(q1.isEmpty())
                                break;
                            q2.add(top);
                        }
                    } else if(!q2.isEmpty()) {
                        while(!q2.isEmpty()) {
                            top = q2.remove();
                            if(q2.isEmpty())
                                break;
                            q1.add(top);
                        }
                    } else
                        System.out.println("Queue is empty!");
                    System.out.println(top + " is popped successfully!");
                    break;
                case 3:
                    top = -1;
                    if(!q1.isEmpty()) {
                        while(!q1.isEmpty()) {
                            top = q1.remove();
                            q2.add(top);
                        }
                        System.out.println("Peek result: " + top);
                    } else if(!q2.isEmpty()) {
                        while(!q2.isEmpty()) {
                            top = q2.remove();
                            q1.add(top);
                        }
                        System.out.println("Peek result: " + top);
                    } else System.out.println("Queue is empty!");

                    break;
                case 4:
                    if(!q1.isEmpty())
                        System.out.println(q1);
                    else if(!q2.isEmpty())
                        System.out.println(q2);
                    else
                        System.out.println("[]");
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
