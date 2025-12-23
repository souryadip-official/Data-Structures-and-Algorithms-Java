import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
public class ConnectingCitiesWithMinimumCost {
    public static class Edge {
        int src_city;
        int dest_city;
        int cost;
        Edge (int sc, int dc, int c) {
            this.src_city = sc;
            this.dest_city = dc;
            this.cost = c;
        }
    }
    public static class VertexCost implements Comparable<VertexCost> {
        int vertex;
        int cost;
        VertexCost(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
        @Override
        public int compareTo(VertexCost v2) {
            return this.cost - v2.cost;
        }
    }
    public static int connectingCities(int[][] cities) {
        ArrayList<Edge>[] graph = new ArrayList[cities.length];
        for (int i=0; i<graph.length; i++)
            graph[i] = new ArrayList<>(); // Adding an empty arraylist to every vertex
        for (int i=0; i<cities.length; i++) {
            for (int j=0; j<cities[0].length; j++) {
                if (cities[i][j] != 0)
                    graph[i].add(new Edge(i, j, cities[i][j]));
            }
        }
        // Now this is a simple Prim's Algorithm Question
        int finalMSTCost = 0;
        boolean[] visited = new boolean[graph.length];
        int[] cost = new int[graph.length]; // cost[i] = minimum weight edge that can connect vertex i to MST
        Arrays.fill(cost, Integer.MAX_VALUE);
        PriorityQueue<VertexCost> pq = new PriorityQueue<>();
        pq.add(new VertexCost(0, 0));
        cost[0] = 0; // Cost of connecting 0 starting with 0 to the MST is 0
        while (!pq.isEmpty()) { // Avoids revisiting or reprocessing of vertices already evaluated
            VertexCost curr = pq.remove();
            int curr_vertex = curr.vertex;
            int curr_cost = curr.cost;
            if (!visited[curr_vertex]) {
                visited[curr_vertex] = true;
                finalMSTCost += curr_cost;
                for (int i=0; i<graph[curr_vertex].size(); i++) {
                    Edge curr_neighbor = graph[curr_vertex].get(i);
                    int curr_neighbor_dest = curr_neighbor.dest_city;
                    int curr_neighbor_cost = curr_neighbor.cost;
                    if (!visited[curr_neighbor_dest] && curr_neighbor_cost < cost[curr_neighbor_dest]) {
                        cost[curr_neighbor_dest] = curr_neighbor_cost;
                        pq.add(new VertexCost(curr_neighbor_dest, curr_neighbor_cost));
                    }
                }
            }
        }
        return finalMSTCost;
    }
    public static void main(String[] args) {
        int[][] cities = {{0,1,2,3,4}, {1,0,5,0,7}, {2,5,0,6,0}, {3,0,6,0,0}, {4,7,0,0,0}}; // In this question, input is given in the form of Adjacency Matrix
        // Here, if cities[i][j] > 0, city i is connected with city j with cost cities[i][j] else if it 0, then no connection
        System.out.println("Connecting cities minimum cost: " + connectingCities(cities));
    }
}
