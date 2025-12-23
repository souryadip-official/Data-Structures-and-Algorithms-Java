import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class KruskalAlgorithm {
    public static class Edge implements Comparable<Edge> {
        int src, dest, wt;
        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
        @Override
        public int compareTo(Edge e2) {
            return this.wt - e2.wt;
        }
    }
    public static int find(int element, int[] parent) {
        if (element == parent[element]) return element;
        else {
            parent[element] = find(parent[element], parent);
            return parent[element];
        }
    }
    public static void union(int a, int b, int[] parent, int[] rank) {
        int root_for_a = find(a, parent);
        int root_for_b = find(b, parent);
        if (root_for_a != root_for_b) {
            if (rank[root_for_a] > rank[root_for_b]) parent[root_for_b] = root_for_a;
            else if (rank[root_for_b] > rank[root_for_a]) parent[root_for_a] = root_for_b;
            else {
                int random_choice = (int) Math.round(Math.random());
                if (random_choice == 0) {
                    parent[root_for_a] = root_for_b;
                    rank[root_for_b]++;
                } else {
                    parent[root_for_b] = root_for_a;
                    rank[root_for_a]++;
                }
            }
        }
    }
    public static int kruskalMST(ArrayList<Edge> edges, int n, int[] parent, int[] rank) {
        Collections.sort(edges); // Sorts the edges in the ascending order of their weights
        int finalMSTCost = 0;
        int edgesAdded = 0;
        for (int i=0; i<edges.size() && edgesAdded < n-1; i++) {
            /* This is because a minimum spanning tree has at most n-1 edges (n is the number of vertices). It has exactly n-1 edges when the graph is fully connected or has less than that. i < edges.size() ensures that if the graph is disconnected, then also IndexOutOfBoundsException is avoided. But if we have a connected graph, as soon as our edgesAdded becomes n-1 we break */
            Edge e = edges.get(i);
            int root_for_src = find(e.src, parent);
            int root_for_dest = find(e.dest, parent);
            if (root_for_src != root_for_dest) {
                union(e.src, e.dest, parent, rank);
                finalMSTCost += e.wt;
                edgesAdded++;
            }
        }
        return finalMSTCost;
    }
    public static int minimumCostSpanningTreeKruskal(ArrayList<Edge>[] graph) {
        int n = graph.length;
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i=0; i<n; i++) {
            for (int j=0; j<graph[i].size(); j++)
                edges.add(graph[i].get(j));
        }
        int[] rank = new int[n];
        int[] parent = new int[n];
        for (int i=0; i<n; i++) parent[i] = i;
        return kruskalMST(edges, n, parent, rank);
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
        System.out.println("Cost of the Minimum Spanning Tree (MST) = " + minimumCostSpanningTreeKruskal(gph));
    }
}
