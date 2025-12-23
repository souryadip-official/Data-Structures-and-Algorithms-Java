import java.util.Scanner;
import java.util.Random;

public class Lottery01 {
    public static void main(String[] args) {
        Random rand = new Random();
        int lottery = rand.nextInt(90) + 10; // Ensuring a 2-digit number (10-99)

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a two-digit number: ");
        int userGuess = scanner.nextInt();
        scanner.close();

        // Extract digits
        int lotteryDigit1 = lottery / 10;
        int lotteryDigit2 = lottery % 10;
        int userDigit1 = userGuess / 10;
        int userDigit2 = userGuess % 10;

        System.out.println("Lottery number: " + lottery);

        // Check conditions
        if (userGuess == lottery) {
            System.out.println("Exact match! You win Rs. 10000");
        } else if ((userDigit1 == lotteryDigit2 && userDigit2 == lotteryDigit1)) {
            System.out.println("Matched digits in different order! You win Rs. 3000");
        } else if (userDigit1 == lotteryDigit1 || userDigit1 == lotteryDigit2 ||
                userDigit2 == lotteryDigit1 || userDigit2 == lotteryDigit2) {
            System.out.println("Matched one digit! You win Rs. 1000");
        } else {
            System.out.println("Sorry, no match.");
        }
    }
}
