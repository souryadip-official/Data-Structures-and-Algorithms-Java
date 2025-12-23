import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class CheapestFlightWithKStops {
    public static class Flight {
        int from, to, price;
        Flight(int from, int to, int price) {
            this.from = from;
            this.to = to;
            this.price = price;
        }
    }
    public static class VertexPriceInfo {
        int vertex;
        int price;
        int stops; // Tracks the total stops to reach this cost
        VertexPriceInfo(int vertex, int price, int stops) {
            this.vertex = vertex;
            this.price = price;
            this.stops = stops;
        }
        /* In this question, stop is the most important decisive feature as compared to cost. This is because, we may have to select for a path whose cost is higher if it does not satisfy the maximum stops condition. */
    }
    public static int cheapestFlights(ArrayList<Flight>[] flights, int src, int dest, int k) {
        int[] price = new int[flights.length];
        for (int i=0; i<price.length; i++)
            price[i] = (i == src? 0 : Integer.MAX_VALUE);
        Queue<VertexPriceInfo> queue = new LinkedList<>();
        queue.add(new VertexPriceInfo(src, 0, 0)); // Since we are storing the flights based on their stops, and stops increases by one when moved from one vertex to another, it is automatically stored in a sorted fashion. So we don't explicitly need a Priority Queue
        while (!queue.isEmpty()) {
            VertexPriceInfo curr = queue.remove();
            int curr_vertex = curr.vertex;
            int curr_price = curr.price;
            int curr_stops = curr.stops;
            if (curr_stops > k) continue; // We have already reached the bottleneck of this specific route
            for (int i=0; i<flights[curr_vertex].size(); i++) {
                Flight curr_neighbor_vertex = flights[curr_vertex].get(i);
                int u = curr_neighbor_vertex.from;
                int v = curr_neighbor_vertex.to;
                int w = curr_neighbor_vertex.price;
                if (curr_price + w < price[v]) {
                    price[v] = curr_price + w;
                    queue.add(new VertexPriceInfo(v, price[v], curr_stops + 1));
                }
            }
        }
        // Final cost
        if (price[dest] == Integer.MAX_VALUE) return -1; // There is no route from source to destination
        else return price[dest];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of flights ---> ");
        int f = sc.nextInt();
        ArrayList<Flight>[] flights = new ArrayList[f];
        for (int i=0; i<f; i++) flights[i] = new ArrayList<>();
        for (int i=0; i<f; i++) {
            boolean cont;
            System.out.print("Is there any route for flight " + i + "? (true | false) ");
            cont = sc.nextBoolean();
            ArrayList<Flight> temp = new ArrayList<>();
            if (cont) {
                System.out.println("Enter connection details for flight " + i + ": ");
                while (cont) {
                    System.out.print("Enter destination ---> ");
                    int dest = sc.nextInt();
                    System.out.print("Enter cost (Enter 1 for unweighted route) ---> ");
                    int cost = sc.nextInt();
                    temp.add(new Flight(i, dest, cost));
                    System.out.print("Continue with details for flight " + i + "? (true for YES | false for NO) ---> ");
                    cont = sc.nextBoolean();
                }
            }
            flights[i] = temp;
        }
        System.out.print("Enter source: ");
        int src = sc.nextInt();
        System.out.print("Enter destination: ");
        int dest = sc.nextInt();
        System.out.print("Enter stops: ");
        int k = sc.nextInt();
        System.out.println("Minimum cost: " + cheapestFlights(flights, src, dest, k));
    }
}