import java.util.Stack;
import java.util.Scanner;
public class StockSpanProblem {
    public static void display(int[] arr) {
        for(int i=0; i<arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    public static int[] brute_force(int[] stocks) {
        int[] span = new int[stocks.length];
        int daysCount = 0;
        for(int i=0; i<stocks.length; i++) {
            for(int j=i; j>=0; j--) {
                if(stocks[j] <= stocks[i]) daysCount++;
                else break;
                /* this is done so that as soon as we receive a stock price greater than current days stock price, we exit. This is done to ensure that the consecutive days criteria is not violated (because it may so happen that for some j < k < i, stocks[j] <= stocks[i] but stocks[k] > stocks[i] */
            }
            span[i] = daysCount;
            daysCount = 0;
        }
        return span;
    }
    public static int[] optimised(int[] stocks) {
        Stack<Integer> stack = new Stack<>();
        int[] span = new int[stocks.length];
        span[0] = 1; /* the first day will have span of 1, because there is only one day which is the first day itself */
        /* Concept: Span of a day is the difference of the day number and the index of the day when the stock price was the high previously. Say we have 100 40 45 60. The span of 60 or we can say day 3 (0-based index) is nothing but 3-0 = 3 (0 because 100 was the day when the stock price was greater than the current days stock price. This is justified because for 100 40 45 60, 60 was same or high from day 1 to day 3 which is 3 itself */
        stack.push(0); /* this is because for the first day (0th day - 0 based index), day 0 itself was the last day where the stock price was <= the current days price. Since the stack stores the index of the previous highest stock price day, hence index 0 is pushed onto the stack */
        for(int i=1; i<stocks.length; i++) {
            while(!stack.isEmpty() && stocks[stack.peek()] <= stocks[i]) stack.pop();
            if(!stack.isEmpty()) span[i] = i - stack.peek();
            else span[i] = i + 1; /* i - (-1), because the stack is now at -1 (empty) */
            stack.push(i); /* so that the latest previous high is maintained */
            /* Basically we push that indices onto the stack whose value is > the stock of current day */
        }
        return span;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of stocks: ");
        int n = sc.nextInt();
        int[] stocks = new int[n];
        int[] span = new int[n];
        /* Stocks basically mean the price of share of a company at a particular day. Stock span problem deals with finding out the number of consecutive days in past for which the stock price was less than or equal to the current days stock price including the current day */
        System.out.print("Enter the " + n + " stocks: ");
        for(int i=0; i<n; i++) stocks[i] = sc.nextInt();
        // span = brute_force(stocks);
        span = optimised(stocks);
        display(span);
        sc.close();
    }
}
