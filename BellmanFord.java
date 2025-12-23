import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
public class BellmanFord {
    public static class Edge {
        int src, dest, wt;
        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
    public static void shortestPathBF(ArrayList<Edge>[] graph, int src) {
        // Function to calculate the shortest path using Bellman Ford Algorithm between src and every other pair of vertices in a graph containing negative edge weights
        int[] distance = new int[graph.length]; // To store the distance between src and all other vertices
        for (int i=0; i<distance.length; i++)
            distance[i] = (i == src? 0 : Integer.MAX_VALUE);

        ArrayList<Edge> edges = new ArrayList<>();
        // Adding all the edges in a single arraylist
        for (int i=0; i<graph.length; i++) {
            for (int j=0; j<graph[i].size(); j++)
                edges.add(graph[i].get(j));
        }
        // Relaxation steps
        boolean changesDone = false;
        for (int iter=1; iter<=graph.length-1; iter++) { // Iteration 1 to V-1 (Requirement of Bellman-Ford Algorithm)
            for (int j=0; j<edges.size(); j++) {
                Edge e = edges.get(j);
                int curr_src = e.src;
                int curr_dest = e.dest;
                int curr_wt = e.wt;
                if (distance[curr_src] != Integer.MAX_VALUE && distance[curr_src] + curr_wt < distance[curr_dest]) {
                    distance[curr_dest] = distance[curr_src] + curr_wt;
                    changesDone = true;
                }
            }
            if (!changesDone) break; // when there is no change between two consecutive iterations, means we have already reached the final state
            else changesDone = false;
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
        shortestPathBF(gph, src);
    }
}