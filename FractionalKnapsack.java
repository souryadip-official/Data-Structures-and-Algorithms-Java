import java.util.Scanner;
class Item {
    int index;
    int value;
    int weight;
    double ratio;
}
public class FractionalKnapsack {
    public static void merge(Item[] items, int low, int mid, int high) {
        int size = high - low + 1;
        Item[] newItems = new Item[size];
        int i = low, j = mid+1, idx = 0;
        while(i <= mid && j <= high) {
            if(items[i].ratio >= items[j].ratio)
                newItems[idx++] = items[i++];
            else
                newItems[idx++] = items[j++];
        }
        while(i <= mid) newItems[idx++] = items[i++];
        while(j <= high) newItems[idx++] = items[j++];

        for(int k=0; k<newItems.length; k++)
            items[k + low] = newItems[k];
    }
    public static void mergeSort(Item[] items, int low, int high) {
        if(low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(items, low, mid);
            mergeSort(items, mid+1, high);
            merge(items, low, mid, high);
        }
    }
    public static void fractional_knapsack(Item[] items, int capacity) {
        /* First, we need to sort the array in decreasing order of their value/weight ratio */
        mergeSort(items, 0, items.length-1);
        double totalProfit = 0.0;
        for(int i=0; i<items.length && capacity > 0; i++) {
            if(items[i].weight <= capacity) {
                totalProfit += items[i].value;
                capacity -= items[i].weight;
            } else {
                double profit = ((double) capacity / items[i].weight) * items[i].value;
                /* or we may directly do: double profit = capacity * items[i].ratio; */
                totalProfit += profit;
                break;
            }
        }
        System.out.println("Total profit: " + totalProfit);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();
        Item[] items = new Item[n];
        for(int i=0; i<n; i++) {
            items[i] = new Item();
            System.out.print("Enter the value and weight of item " + (i+1) + ": ");
            items[i].value = sc.nextInt();
            items[i].weight = sc.nextInt();
            items[i].index = i;
            items[i].ratio = (double) items[i].value / items[i].weight;
        }
        System.out.print("Enter the knapsack capacity: ");
        int capacity = sc.nextInt();
        fractional_knapsack(items, capacity);
        sc.close();
    }
}
