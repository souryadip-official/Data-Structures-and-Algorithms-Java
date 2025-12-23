import java.util.*;
public class BuyAndSellStocks {
    public static void calculateProfit(int[] arr) {
        int i, buyDay = 0, minBuyPrice = Integer.MAX_VALUE, n = arr.length, currDayProfit, overallProfit = 0, profitDay = 0;
        for(i=0;i<n;i++) {
            if(arr[i] < minBuyPrice) {
                minBuyPrice = arr[i];
                buyDay = i+1;
            }
            currDayProfit = arr[i] - minBuyPrice;
            if(currDayProfit > overallProfit) {
                overallProfit = currDayProfit;
                profitDay = i+1;
            }
        }
        System.out.println("\nResults:");
        if(overallProfit > 0)
            System.out.println("If user buy stock on DAY "+ buyDay + " and sell the stock on DAY " + profitDay + ", they can make a profit of Rs. " + overallProfit+".");
        else
            System.out.println("User cannot make any profit.");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int data, i;
        System.out.print("Enter number of data: ");
        data = sc.nextInt();
        System.out.println();
        if(data <= 0) {
            System.out.println("Invalid size.");
            System.exit(0);
        }
        int[] arr = new int[data];
        /* Java type declaration of arrays */
        for(i=0;i<data;i++) {
            System.out.print("Enter price on DAY " + (i+1) + ": ");
            arr[i] = sc.nextInt();
            if(arr[i] < 0) {
                System.out.println("Price cannot be negative.");
                System.exit(0);
            }
        }
        calculateProfit(arr);
    }
}
