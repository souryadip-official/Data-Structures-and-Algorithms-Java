import java.util.*;
public class ReverseOfANumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter any number: ");
        int num = sc.nextInt();
        int absnum = (num < 0)? (-1 * num) : num, rev=0;
        while(absnum > 0) {
            rev = (rev * 10) + (absnum % 10);
            // absnum % 10 will give us the last digit of the number
            absnum = absnum / 10;
            /* absnum / 10 will make the last digit shift to a decimal point, and
               as the calculations are done in int data type, the value will hence
               be rounded off to the integer portion, hence the last digit would be
               removed from the number */
        }
//        int rev2 = 0;
//        for(int temp = (num < 0)? (-1 * num) : num; temp > 0; temp /= 10) {
//            rev2 = (rev2 * 10) + (temp % 10);
//        }   ----> For loop condition of solving the same problem
        if(num < 0) {
            System.out.println("Reverse of the number is: -" + rev);
        } else {
            System.out.println("Reverse of the number is: "+rev);
        }
    }
}
