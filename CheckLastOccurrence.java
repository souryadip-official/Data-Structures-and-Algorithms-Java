import java.util.Scanner;
public class CheckLastOccurrence {
    public int getLastOccur(int[] arr, int i, int key) {
        if(i == arr.length-1) {
            if(arr[i] == key)
                return i;
            else
                return -1;
        } else {
            if(arr[i] == key) {
                int idx = getLastOccur(arr,i+1,key);
                if(idx != -1)
                    return idx;
                else
                    return i;
            } else
                return getLastOccur(arr,i+1,key);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();
        if (size <= 0) {
            System.out.println("Invalid size!");
            return;
        }
        int[] arr = new int[size];
        System.out.print("Enter " + size + " elements of the array: ");
        for(int i=0;i<size;i++)
            arr[i] = sc.nextInt();
        System.out.print("Enter the element to search: ");
        int key = sc.nextInt();
        CheckLastOccurrence c = new CheckLastOccurrence();
        int idx = c.getLastOccur(arr,0,key);
        System.out.println(idx == -1? (key + " is not found (no last occurrence).") : (key + " has last occurrence at index " + idx));
        sc.close();
    }
    /*
    if(i == 0) {
            if(arr[i] == key)
                return i;
            return -1;
        }
        if(arr[i] == key)
            return i;
        else
            return getLastOccur(arr,i-1,key);
     */
}
