import java.util.Scanner;
public class ShortestPath {
    public static boolean checkRouteValidity(String str) {
        for(int i=0;i<str.length();i++) {
            char c = Character.toUpperCase(str.charAt(i));
            if(c != 'N' && c != 'E' && c != 'S' && c != 'W')
                return false;
        }
        return true;
    }
    public static float calculateShortestPath(int x1, int y1, int x2, int y2) {
        int x = (int) Math.pow((x2 - x1), 2);
        int y = (int) Math.pow((y2 - y1), 2);
        return (float) Math.sqrt(x + y);
    }
    public static float getShortestPath(String str, int startX, int startY) {
        int i, n = str.length(), x=startX, y=startY;
        for(i=0;i<n;i++) {
            char c = Character.toUpperCase(str.charAt(i));
            if(c == 'N') y++;
            else if(c == 'E') x++;
            else if(c == 'S') y--;
            else x--;
            System.out.println(x + " " + y);
        }
        System.out.println(x + " " + y);
        return calculateShortestPath(x, y, startX, startY);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter route: ");
        String str = sc.next();
        boolean isValid = checkRouteValidity(str);
        if(!isValid) {
            System.out.println("Invalid route!");
            return;
        }
        System.out.print("At what x and y are you currently at (only integer)? ");
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.printf("Shortest Path: %.2f\n", getShortestPath(str, x, y));
        /* This method is best for directly printing formatted output without converting it to a string. For example, System.out.printf("%.2f%n", 12.34567f) gives Output: 12.35 where %n is a platform-independent newline character in Java (same as \n) but works on any OS */
    }
}
