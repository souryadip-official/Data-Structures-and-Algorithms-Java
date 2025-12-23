import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;
public class TopologicalSortBFS {
    public static class Edge {
        int src, dest, wt;
        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
    public static void topologicalSortBFS(ArrayList<Edge>[] graph) {
        // Topological Sort using Kahn's Algorithm (BFS Approach)
        int[] inDegree = new int[graph.length];
        for (int i=0; i<inDegree.length; i++) inDegree[i] = 0; // Initially, in degree of all vertex is 0
        for (int i=0; i<graph.length; i++) {
            for(int j=0; j<graph[i].size(); j++) {
                int curr = graph[i].get(j).dest;
                inDegree[curr]++;
            }
        } // This will correctly evaluate the in degree for all the vertices in the graph
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<inDegree.length; i++) {
            if(inDegree[i] == 0) queue.add(i);
        }
        while (!queue.isEmpty()) {
            int curr = queue.remove();
            System.out.print(curr + " ");
            for (int i=0; i<graph[curr].size(); i++) {
                int currNeighbor = graph[curr].get(i).dest;
                inDegree[currNeighbor]--;
                if(inDegree[currNeighbor] == 0)
                    queue.add(currNeighbor); // adding back the neighbors whose indegree has become 0
            }
        }
        System.out.println();
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
        topologicalSortBFS(gph);
    }
}