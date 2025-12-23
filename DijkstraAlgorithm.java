import java.util.ArrayList;
import java.util.Scanner;
import java.util.PriorityQueue;
public class DijkstraAlgorithm {
    public static class Edge {
        int src, dest, wt;
        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
    public static class Pair implements Comparable<Pair> {
        int vertex;
        int distance;
        Pair(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
        @Override
        public int compareTo(Pair p2) {
            return this.distance - p2.distance; // It compares two Pair objects by their distance value so that pairs with smaller distance come first when sorting
        }
    }
    public static void shortestPath(ArrayList<Edge>[] graph, int src) {
        // Function to calculate the shortest path using Dijkstra's Algorithm between src and every other pair of vertices
        boolean[] visited = new boolean[graph.length];
        int[] distance = new int[graph.length]; // To store the distance between src and all other vertices
        for (int i=0; i<distance.length; i++)
            distance[i] = (i == src? 0 : Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, distance[src])); // Adding the source to the Priority Queue
        while (!pq.isEmpty()) {
            Pair curr = pq.remove(); // Extracting vertex with the smallest distance from the priority queue
            int curr_vertex = curr.vertex;
            int curr_dist = curr.distance;
            if (!visited[curr_vertex]) { // To prevent reprocessing of vertices
                visited[curr_vertex] = true;
                for (int i = 0; i<graph[curr_vertex].size(); i++) {
                    Edge curr_neighbor_edge = graph[curr_vertex].get(i);
                    if (curr_dist + curr_neighbor_edge.wt < distance[curr_neighbor_edge.dest]) {
                        distance[curr_neighbor_edge.dest] = curr_dist + curr_neighbor_edge.wt;
                        pq.add(new Pair(curr_neighbor_edge.dest, distance[curr_neighbor_edge.dest]));
                    }
                }
            }
        }
        // Printing all the shortest path from source to other vertices
        for (int i=0; i<distance.length; i++)
            System.out.println("Shortest distance from Vertex " + src + " to Vertex " + i + ": " + distance[i]);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices ---> ");
        int v = sc.nextInt();
        ArrayList<Edge>[] gph = new ArrayList[v];
        for (int i=0; i<v; i++) gph[i] = new ArrayList<>();
        for (int i=0; i<v; i++) {
            boolean cont;
            System.out.print("Is there any outgoing edge for vertex " + i + "? (true | false) ");
            cont = sc.nextBoolean();
            ArrayList<Edge> temp = new ArrayList<>();
            if (cont) {
                System.out.println("Enter connection details for vertex " + i + ": ");
                while (cont) {
                    System.out.print("Enter destination ---> ");
                    int dest = sc.nextInt();
                    System.out.print("Enter weight (Enter 1 for unweighted graph) ---> ");
                    int wt = sc.nextInt();
                    temp.add(new Edge(i, dest, wt));
                    System.out.print("Continue with details for vertex " + i + "? (true for YES | false for NO) ---> ");
                    cont = sc.nextBoolean();
                }
            }
            gph[i] = temp;
        }
        System.out.print("Enter source: ");
        int src = sc.nextInt();
        shortestPath(gph, src);
    }
}
