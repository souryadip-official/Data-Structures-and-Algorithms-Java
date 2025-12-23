import java.util.*;
public class Graphs02 {
    public static class Edge {
        int src, dest, wt;
        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
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
        System.out.println("Number of connected components: " + connectedComponentsUtil(gph));
    }
}
