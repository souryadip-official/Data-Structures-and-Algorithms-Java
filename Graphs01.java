import java.util.*;
import java.util.Queue;
public class Graphs01 {
    public static class Edge {
        int src, dest, wt;
        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static ArrayList<Integer> getNeighbours(ArrayList<Edge>[] gph, int vertex) {
        ArrayList<Integer> nb = new ArrayList<>();
        for(int i=0; i<gph[vertex].size(); i++)
            nb.add(gph[vertex].get(i).dest);
        return nb;
    }

    public static void bfs(ArrayList<Edge>[] gph, int src, boolean[] visited) { // Time Complexity: O(V+E), Space Complexity: O(V)
        Queue<Integer> q = new LinkedList<>();
        // In Java, the default value for elements in a boolean array is false
        q.add(src);
        visited[src] = true;
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");
            // Adding the rest of its neighbors to the queue
            for (Edge e: gph[curr]) {
                int curr_dest = e.dest;
                if (!visited[curr_dest]) {
                    q.add(curr_dest);
                    visited[curr_dest] = true;
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] gph, int vertex, boolean[] visited) { // Time Complexity: O(V+E), Space Complexity: O(V)
        visited[vertex] = true;
        System.out.print(vertex + " ");
        for (int i=0; i<gph[vertex].size(); i++) {
            int curr_dest = gph[vertex].get(i).dest;
            if (!visited[curr_dest])
                dfs(gph, curr_dest, visited);
        }
    }

    public static boolean hasPath(int src, int dest, ArrayList<Edge>[] gph, boolean[] visited) {
        if (src == dest) return true; // we have reached our destination node
        visited[src] = true;
        for(int i=0; i<gph[src].size(); i++) {
            int curr_dest = gph[src].get(i).dest;
            if (!visited[curr_dest]) { // to avoid cycles in the graph
                boolean ans = hasPath(curr_dest, dest, gph, visited);
                if (ans) return true;
            }
        }
        return false;
    }

    public static void dfs_modified(ArrayList<Edge>[] gph, int vertex, boolean[] visited) {
        visited[vertex] = true;
        for(int i=0; i<gph[vertex].size(); i++) {
            int curr_dest = gph[vertex].get(i).dest;
            if (!visited[curr_dest])
                dfs_modified(gph, curr_dest, visited);
        }
    }
    public static int connectedComponentsUtil(ArrayList<Edge>[] gph) {
        // calculating the number of connected components
        int count = 0;
        boolean[] visited = new boolean[gph.length];
        for (int i=0; i<gph.length; i++) {
            if (!visited[i]) {
                dfs_modified(gph, i, visited);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int v = sc.nextInt();
        ArrayList<Edge>[] gph = new ArrayList[v];
        for (int i=0; i<v; i++) gph[i] = new ArrayList<>();

        for(int i=0; i<v; i++) {
            System.out.println("Enter connection details for vertex " + i + ": ");
            boolean cont = true;
            ArrayList<Edge> temp = new ArrayList<>();
            while (cont) {
                System.out.print("Enter destination: ");
                int dest = sc.nextInt();
                System.out.print("Enter weight (Enter 1 for unweighted graph): ");
                int wt = sc.nextInt();
                temp.add(new Edge(i, dest, wt));
                System.out.print("Continue with details for vertex " + i + "? (true for YES | false for NO) ---> ");
                cont = sc.nextBoolean();
            }
            gph[i] = temp;
        }
        System.out.print("BFS Traversal: ");
        boolean[] visited = new boolean[gph.length];
        for (int i=0; i<visited.length; i++) {
            if (!visited[i])
                bfs(gph, i, visited);
        } // this ensures that bfs is correctly evaluated even for disjoint graphs

        System.out.print("\nDFS Traversal: ");
        visited = new boolean[gph.length];
        for (int i=0; i<visited.length; i++) {
            if (!visited[i])
                dfs(gph, i, visited);
        } // this ensures that dfs is correctly evaluated even for disjoint graphs

        visited = new boolean[gph.length];
        System.out.print("\nEnter source: ");
        int src = sc.nextInt();
        System.out.print("Enter destination: ");
        int dest = sc.nextInt();
        System.out.println("\nHas path between " + src + "-" + dest + ": " + hasPath(src, dest, gph, visited));
        System.out.println("Number of connected components: " + connectedComponentsUtil(gph));
    }
}
