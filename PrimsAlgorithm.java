import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.PriorityQueue;
public class PrimsAlgorithm {
    public static class Edge {
        int src, dest, wt;
        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
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
    public static int minimumCostSpanningTree(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length]; // This tracks the vertices already considered in the MST
        int[] cost = new int[graph.length]; // Tracks the cost of adding each vertex to the MST
        for (int i=0; i<cost.length; i++)
            cost[i] = Integer.MAX_VALUE; // cost[i] = minimum weight edge that can connect vertex i to MST

        PriorityQueue<VertexCost> pq = new PriorityQueue<>();
        pq.add(new VertexCost(0, 0)); // Starting with vertex 0 whose cost is 0
        cost[0] = 0; // this is because cost connecting vertex 0 is 0

        int finalMSTCost = 0; // cost of the minimum spanning tree
        while (!pq.isEmpty()) {
            VertexCost curr = pq.remove();
            int curr_vertex = curr.vertex;
            int curr_cost = curr.cost;
            if (!visited[curr_vertex]) { // Avoids revisiting or reprocessing of vertices already evaluated
                visited[curr_vertex] = true;
                finalMSTCost += curr_cost;
                for (int j=0; j<graph[curr_vertex].size(); j++) {
                    Edge curr_neighbor = graph[curr_vertex].get(j);
                    int curr_neighbor_dest = curr_neighbor.dest;
                    int curr_neighbor_wt = curr_neighbor.wt;
                    if (!visited[curr_neighbor_dest] && curr_neighbor_wt < cost[curr_neighbor_dest]) {
                        cost[curr_neighbor_dest] = curr_neighbor_wt;
                        pq.add(new VertexCost(curr_neighbor.dest, curr_neighbor.wt));
                    } // Adding the neighbor only if it is unvisited and its cost to add it to the MST is more than the current edge cost. This is the core logic of Prim's Algorithm because this ensures picking the minimum weight edge that connects the MST to a new vertex (unvisited vertex).
                }
            }
        }
        return finalMSTCost;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices ---> ");
        int v = sc.nextInt();
        ArrayList<Edge>[] gph = new ArrayList[v];
        for (int i=0; i<v; i++) gph[i] = new ArrayList<>();
        for (int i=0; i<v; i++) {
            boolean cont;
            System.out.print("Is there any edge for vertex " + i + "? (true | false) ");
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
        System.out.println("Cost of the Minimum Spanning Tree (MST) = " + minimumCostSpanningTree(gph));
    }
}