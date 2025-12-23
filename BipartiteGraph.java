import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;
public class BipartiteGraph {
    public static class Edge {
        int src, dest, wt;
        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static boolean isBipartiteUtil(ArrayList<Edge>[] gph, int vertex, int[] color, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        visited[vertex] = true;
        color[vertex] = 0; // Starting with color yellow. Although we can start from 1 as well
        q.add(vertex);
        int nextColor = 1; // the color we need to assign to the next vertex (we started with 0 {yellow})
        while(!q.isEmpty()) {
            int curr_vertex = q.remove();
            if (color[curr_vertex] == 0) nextColor = 1;
            else nextColor = 0;
            for (Edge e: gph[curr_vertex]) {
                int neighbor = e.dest;
                if (!visited[neighbor]) {
                    q.add(neighbor);
                    visited[neighbor] = true;
                    color[neighbor] = nextColor;
                } else if (visited[neighbor] && color[curr_vertex] == color[neighbor])
                    return false;
            }
        }
        return true;
    }

    public static boolean isBipartite(ArrayList<Edge>[] gph) {
        int[] color = new int[gph.length];
        boolean[] visited = new boolean[gph.length];
        for (int i=0; i<color.length; i++)
            color[i] = -1; // this initializes the color array. (-1 means that specific vertex is uncolored)
        /* Color has two possible values:
            (a) Yellow (We can consider integer value 0 to denote yellow)
            (b) Blue (We can consider integer value 1 to denote blue)
            (Apart from yellow and blue, you can think of any other color as well */
        for(int i=0; i<gph.length; i++) {
            if (!visited[i]) {
                boolean res = isBipartiteUtil(gph, i, color, visited);
                if (!res) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices ---> ");
        int v = sc.nextInt();
        ArrayList<Edge>[] gph = new ArrayList[v];
        for (int i = 0; i < v; i++) gph[i] = new ArrayList<>();
        for (int i = 0; i < v; i++) {
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
        System.out.println("Is bipartite? " + isBipartite(gph));
    }
}