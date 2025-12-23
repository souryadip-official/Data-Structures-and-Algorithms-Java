import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
public class TopologicalSort {
    public static class Edge {
        int src, dest, wt;
        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void topologicalSortUtil(ArrayList<Edge>[] graph, int vertex, boolean[] visited, Stack<Integer> topologicalOrderStack) {
        visited[vertex] = true;
        for (int i=0; i<graph[vertex].size(); i++) {
            int curr = graph[vertex].get(i).dest;
            if (!visited[curr])
                topologicalSortUtil(graph, curr, visited, topologicalOrderStack);
        }
        topologicalOrderStack.push(vertex); // to ensure that the dependency is respected (Stack follows LIFO)
    }

    public static Stack<Integer> topologicalSort(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        Stack<Integer> topologicalOrderStack = new Stack<>();
        for (int i=0; i<graph.length; i++) {
            if (!visited[i]) {
                topologicalSortUtil(graph, i, visited, topologicalOrderStack);
            }
        }
        return topologicalOrderStack;
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
        Stack<Integer> topologicalOrderStack = topologicalSort(gph);
        System.out.print("Topological Sorting Order (Dependency List): ");
        while (!topologicalOrderStack.isEmpty())
            System.out.print(topologicalOrderStack.pop() + " ");
    }
}