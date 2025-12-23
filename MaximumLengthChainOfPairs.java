import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class MaximumLengthChainOfPairs {
    public static void getMaxLengthOfPairs(int[][] pairs) {
        ArrayList<String> list = new ArrayList<>();
        int count = 0;
        list.add("P" + pairs[0][0]);
        int lastEntered = 0;
        count++;
        for(int i=1; i<pairs.length; i++) {
            if(pairs[lastEntered][2] < pairs[i][1]) {
                list.add("P" + pairs[i][0]);
                count++;
                lastEntered = i;
            }
        }
        System.out.println("Maximum length of pairs: " + count);
        System.out.println("The pairs are: " + list);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of pairs: ");
        int n = sc.nextInt();
        int[][] pairs = new int[n][3];
        for(int i=0; i<pairs.length; i++) {
            System.out.print("Enter pair " + (i) + ": ");
            pairs[i][0] = i;
            pairs[i][1] = sc.nextInt();
            pairs[i][2] = sc.nextInt();
        }
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[2]));
        getMaxLengthOfPairs(pairs);
        sc.close();
    }
}
