import java.util.ArrayList;
import java.util.Scanner;
public class CycleDetection01 {
    public static class Edge {
        int src, dest, wt;
        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
    public static boolean hasCycle(ArrayList<Edge>[] gph, int vertex, boolean[] visited, int parent) {
        visited[vertex] = true;
        for (int i=0; i<gph[vertex].size(); i++) {
            int curr_dest = gph[vertex].get(i).dest;
            if (!visited[curr_dest]) {
                if (hasCycle(gph, curr_dest, visited, vertex)) // if we call for a node from the current node, then the parent of the called node is the node through which the node is visited
                    return true;
            } else if (visited[curr_dest] && parent != curr_dest) { // the neighbor is already visited but is not the parent of the current node, then it means that there is some path through which the parent node is reachable from the current node thereby creating a cycle
                return true;
            }
        }
        return false;
    }

    public static boolean detectCycle(ArrayList<Edge>[] gph) {
        boolean[] visited = new boolean[gph.length];
        for (int i=0; i<gph.length; i++) {
            if (!visited[i]) {
                if (hasCycle(gph, i, visited, Integer.MIN_VALUE)) {
                    // cycle exists in one of the components of the graph
                    return true;
                }
                // Every node that is unvisited in this function means a new component. Hence, each vertex that marks the starting of a component has no parent. Hence, Integer.MIN_VALUE;
            }
        }
        return false; // none of the component gives true, hence no cycle exists.
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices ---> ");
        int v = sc.nextInt();
        ArrayList<Edge>[] gph = new ArrayList[v];
        for (int i=0; i<v; i++) gph[i] = new ArrayList<>();
        for (int i=0; i<v; i++) {
            System.out.println("Enter connection details for vertex " + i + ": ");
            boolean cont = true;
            ArrayList<Edge> temp = new ArrayList<>();
            while (cont) {
                System.out.print("Enter destination ---> ");
                int dest = sc.nextInt();
                System.out.print("Enter weight (Enter 1 for unweighted graph) ---> ");
                int wt = sc.nextInt();
                temp.add(new Edge(i, dest, wt));
                System.out.print("Continue with details for vertex " + i + "? (true for YES | false for NO) ---> ");
                cont = sc.nextBoolean();
            }
            gph[i] = temp;
        }
        System.out.println("Cycle exists? " + detectCycle(gph));
    }
}