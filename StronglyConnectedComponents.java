import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
public class StronglyConnectedComponents {
    public static class Edge {
        int src, dest, wt;
        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
    public static void dfs(ArrayList<Edge>[] transposeGraph, boolean[] visited, int src, StringBuilder res) {
        visited[src] = true;
        res.append(src).append(" ");
        for (int i = 0; i< transposeGraph[src].size(); i++) {
            int curr_neighbor = transposeGraph[src].get(i).dest;
            if (!visited[curr_neighbor])
                dfs(transposeGraph, visited, curr_neighbor, res);
        }
    }
    public static void dfsReverseFinishingTimeOrder(ArrayList<Edge>[] graph, Stack<Integer> stack, int src, boolean[] visited) {
        /* This is different from topological ordering because topological sort is defined only for DAGs, whereas DFS finishing-time order works even when the graph contains cycles and is used to order SCCs, not individual vertices. */
        visited[src] = true;
        for(int i=0; i<graph[src].size(); i++) {
            int curr_neighbor = graph[src].get(i).dest;
            if (!visited[curr_neighbor])
                dfsReverseFinishingTimeOrder(graph, stack, curr_neighbor, visited);
        }
        stack.push(src);
    }
    public static void kosarajuSCC(ArrayList<Edge>[] graph) {
        ArrayList<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[graph.length];

        /* First DFS pass to find out the DFS reverse finishing time ordering */
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<graph.length; i++) {
            if (!visited[i])
                dfsReverseFinishingTimeOrder(graph, stack, i, visited);
        }

        /* Transpose of the graph */
        ArrayList<Edge>[] transposeGraph = new ArrayList[graph.length];
        for (int i=0; i<transposeGraph.length; i++)
            transposeGraph[i] = new ArrayList<>();

        for (int i=0; i<graph.length; i++) {
            for (int j=0; j<graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                transposeGraph[e.dest].add(new Edge(e.dest, e.src, e.wt));
                /* Adding a new edge by reversing the direction (source <--> destination} */
            }
        }

        /* Second DFS pass based on the stack ordering */
        visited = new boolean[graph.length];
        StringBuilder s = new StringBuilder();
        while (!stack.isEmpty()) {
            int curr_vertex = stack.pop();
            if (!visited[curr_vertex]) {
                dfs(transposeGraph, visited, curr_vertex, s);
                System.out.println(s);
                s = new StringBuilder(); /* Clearing the current strongly connected component for the next one */
            }
        }
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
        kosarajuSCC(gph);
    }
}
