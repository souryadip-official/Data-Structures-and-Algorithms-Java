import java.util.ArrayList;
import java.util.Scanner;
public class CycleDetectionDirected {
    public static class Edge {
        int src, dest, wt;
        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, int vertex, boolean[] visited, boolean[] currCallStack) {
        visited[vertex] = true;
        currCallStack[vertex] = true;
        for (int i=0; i<graph[vertex].size(); i++) {
            int curr = graph[vertex].get(i).dest;
            if (!visited[curr]) {
                if (detectCycleUtil(graph, curr, visited, currCallStack))
                    return true;
            } else if (visited[curr] && currCallStack[curr]) {
                return true; // Means we have already reached this node earlier and hence is still in the currCallStack formed by the recursion. This is because currCallStack tracks vertices in the current DFS path. If we encounter a vertex already in the current path, it correctly identifies a cycle.
            }
        }
        currCallStack[vertex] = false; // removing the vertex from recursion stack
        return false;
    }

    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        boolean[] currCallStack = new boolean[graph.length];
        for (int i=0; i<graph.length; i++) {
            boolean res = detectCycleUtil(graph, i, visited, currCallStack);
            if (res) return true;
        }
        return false;
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
        System.out.println("Has cycle? " + detectCycle(gph));
    }
}