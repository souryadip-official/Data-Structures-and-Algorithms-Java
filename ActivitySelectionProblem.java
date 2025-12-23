import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.ArrayList;
public class ActivitySelectionProblem {
    public static void activitySelection(int[][] activities) {
        ArrayList<Integer> performed = new ArrayList<>();
        int activitiesCount = 0;
        performed.add(activities[0][0]);
        activitiesCount++;
        for(int i=1; i<activities.length; i++) {
            if(activities[performed.get(performed.size()-1)][2] <= activities[i][1]) {
                performed.add(activities[i][0]);
                activitiesCount++;
            }
        }
        System.out.println("Total tasks performed: " + activitiesCount);
        System.out.println("Tasks are: " + performed);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter total number of activities: ");
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("No activities to perform.");
            return;
        }
        int[] startTime = new int[n];
        int[] endTime = new int[n];
        System.out.println("Enter the start and end times for the " + n + " tasks in sorted order of their end times.");
        int[][] activities = new int[n][3];
        for(int i=0; i<n; i++) {
            activities[i][0] = i;
            System.out.print("Enter start time for activity " + i + ": ");
            activities[i][1] = sc.nextInt();
            System.out.print("Enter end time for activity " + i + ": ");
            activities[i][2] = sc.nextInt();
            System.out.println();
        }
        /* Sorting the array */
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));
        /* This is a lambda function in Java. Lambda functions are a quicker or a shorter way of writing a function. Comparators are interfaces in Java for sorting Java objects. When we need to sort a 2D array based on data of a particular column, the syntax shown above is followed. The syntax basically says we want to sort an array and the comparison factor is going to be the data at column 2 and that is the comparison logic of this sorting. */
        activitySelection(activities);
        sc.close();
    }
}
