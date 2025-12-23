import java.util.ArrayList;
import java.util.Scanner;
public class PathStoT {
    public static class Edge {
        int src, dest, wt;
        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
    public static int paths = 0;
    public static void allPathFromSourceToTargetUtil(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, StringBuilder path) {
        visited[src] = true; // Prevents revisiting the same vertex in the current path to avoid cycles
        int length = Math.abs(path.length() - path.append(src).append(" ").length());
        if (src == dest)
            System.out.println("Path " + (++PathStoT.paths) + ". " + path);
        else {
            for (int i=0; i<graph[src].size(); i++) {
                int curr = graph[src].get(i).dest;
                if (!visited[curr])
                    allPathFromSourceToTargetUtil(graph, curr, dest, visited, path);
            }
        }
        visited[src] = false; // To ensure that in some alternate path, visited being true for a particular vertex does not prevent it from being called again
        path.delete(path.length()-length, path.length());
    }
    public static void allPathFromSourceToTarget(ArrayList<Edge>[] graph, int src, int dest) {
        StringBuilder path = new StringBuilder();
        boolean[] visited = new boolean[graph.length];
        allPathFromSourceToTargetUtil(graph, src, dest, visited, path);
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
        System.out.print("Enter destination: ");
        int dest = sc.nextInt();
        allPathFromSourceToTarget(gph, src, dest);
    }
}