import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class IndianCoins {
    public static int[] findMinNotesorCoins(int value, Integer[] denominations) {
        int[] result = new int[denominations.length];
        for(int i=0; i<denominations.length; i++) {
            while(denominations[i] <= value) {
                result[i]++;
                value = value - denominations[i];
            }
        }
        return result;
    }
    public static void printResult(int[] result, Integer[] denominations, int value) {
        for(int i=0; i<result.length; i++)
            System.out.println(denominations[i] + " * " +  result[i] + " = " + (denominations[i] * result[i]));
        System.out.println("-------------------");
        System.out.println("Total: " + value);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value: ");
        int value = sc.nextInt();
        Integer[] denominations = {2000,500,100,50,20,10,5,2,1};
        Arrays.sort(denominations, Collections.reverseOrder());
        int[] result = findMinNotesorCoins(value, denominations);
        printResult(result, denominations, value);
        sc.close();
    }
}
