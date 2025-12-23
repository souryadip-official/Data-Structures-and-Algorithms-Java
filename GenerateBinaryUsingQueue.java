import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;
public class GenerateBinaryUsingQueue {
    public static ArrayList<String> getBinaryNumbers(int n) {
        Queue<String> queue = new LinkedList<>();
        ArrayList<String> result = new ArrayList<>();
        queue.add("1");
        for(int i=1; i<=n; i++) {
            String val = queue.remove();
            result.add(val);
            queue.add(val + "0");
            queue.add(val + "1");
        }
        /* At this stage, all the binary equivalents of the decimal number in the range 1 to n are generated and stored in the ArrayList result. Thus, we should remove any leftover elements from the queue and then return the result */
        while(!queue.isEmpty()) queue.remove();
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value (n): ");
        int n = sc.nextInt();
        if(n == 0) return;
        ArrayList<String> list = getBinaryNumbers(n);
        System.out.println("Generated binary numbers from range 1 to " + n + " are: " + list);
        sc.close();
    }
}
