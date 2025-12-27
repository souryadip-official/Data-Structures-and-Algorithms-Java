import java.util.Arrays;
import java.util.LinkedHashMap;
public class ItineraryTickets {
    public static void itinerary(String[][] tickets) {
        LinkedHashMap<String, String> forwardJourney = new LinkedHashMap<>();
        LinkedHashMap<String, String> backwardJourney = new LinkedHashMap<>();
        for(int i=0; i<tickets.length; i++) {
            forwardJourney.put(tickets[i][0].toUpperCase(), tickets[i][1].toUpperCase());
            backwardJourney.put(tickets[i][1].toUpperCase(), tickets[i][0].toUpperCase());
        }
        /* Now we need to find the source. The source is that node which is only in source map but not in destination map */
        String start = "";
        for (String src : forwardJourney.keySet()) {
            if (!backwardJourney.containsKey(src)) {
                start = src;
                break;
            }
        }
        System.out.print(start);
        while(forwardJourney.containsKey(start)) {
            String nextDest = forwardJourney.get(start);
            System.out.print(" ---> " + nextDest);
            start = nextDest;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        String[][] tickets = {{"chennai", "bengaluru"}, {"mumbai", "delhi"}, {"goa", "chennai"}, {"delhi", "goa"}};
        System.out.println(Arrays.deepToString(tickets)); /* Used to print multi-dimensional arrays */
        itinerary(tickets);
    }
}
