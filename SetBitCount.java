import java.util.Scanner;
public class SetBitCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = sc.nextInt();
        int temp = n, count = 0;
        while(temp > 0){
            if((temp & 1) == 1)
                count++;
            temp >>= 1;
        }
        System.out.println("Number of set bits in " + n + " is " + count);
        sc.close();
    }
}
