import java.util.Scanner;
import java.util.ArrayList;
public class ContainerWithMostWater {
    public static void bruteForce_find(ArrayList<Integer> lines) {
        int max = Integer.MIN_VALUE, l1 = -1, l2 = -1;
        for(int i=0; i<lines.size(); i++) {
            for(int j=i+1; j<lines.size(); j++) {
                int h1 = lines.get(i);
                int h2 = lines.get(j);
                int waterStored = (j-i) * Math.min(h1, h2);
                if(waterStored > max){
                    l1 = i;
                    l2 = j;
                    max = waterStored;
                }
            }
        }
        System.out.println("Maximum water is stored in container formed by line " + l1 + " and line " + l2 + " and stores " + max + " units of water.");
    }
    /** Using the concept of two pointers. Here, we basically move that pointer either to the left or to the right depending upon which pointer we are talking about, which points to a line of less height. Intuitively we can definitely say that, the maximum water will be contained between the lines formed by the two maximum heights in the array. That is why we check the height of the lines pointed by the two pointers and check which one is smaller. The smaller one gets shifted and the larger one remains as it is. We maintain a maximum variable to store the maximum water and at the end, we print it */
    public static void optimised_find(ArrayList<Integer> lines) {
        int max = Integer.MIN_VALUE, l1 = -1, l2 = -1;
        int leftPointer = 0, rightPointer = lines.size()-1;
        while(leftPointer < rightPointer) {
            int h1 = lines.get(leftPointer);
            int h2 = lines.get(rightPointer);
            int currWater = (rightPointer - leftPointer) * Math.min(h1, h2);
            if(currWater > max) {
                l1 = leftPointer;
                l2 = rightPointer;
                max = currWater;
            }
            if(lines.get(leftPointer) < lines.get(rightPointer))
                leftPointer++;
            else
                rightPointer--;
        }
        System.out.println("Maximum water is stored in container formed by line " + l1 + " and line " + l2 + " and stores " + max + " units of water.");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of lines (n): ");
        int n = sc.nextInt();
        if(n == 1) {
            System.out.println("No container can be formed out of a single line.\nMaximum water stored is 0 units.");
            return;
        } else {
            ArrayList<Integer> lines = new ArrayList<>();
            System.out.print("Enter the value of n lines: ");
            for(int i=1; i<=n; i++) lines.add(sc.nextInt());
            bruteForce_find(lines);
            optimised_find(lines);
            sc.close();
        }
    }
}
