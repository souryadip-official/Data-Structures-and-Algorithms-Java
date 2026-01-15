import java.util.ArrayList;
public class NumberOfProvinces {
    public static void dfs(ArrayList<Integer>[] graph, boolean[] visited, int curr) {
        visited[curr] = true;
        for (int i=0; i<graph[curr].size(); i++) {
            int currDest = graph[curr].get(i);
            if (!visited[currDest]) {
                dfs(graph, visited, currDest);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        /* DFS on an undirected graph and counting every disconnected components */
        int n = isConnected.length;
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i=0; i<n; i++)
            graph[i] = new ArrayList<>();
        boolean[] visited = new boolean[n];

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (i != j && isConnected[i][j] == 1)
                    graph[i].add(j);
            }
        }

        int noOfProvinces = 0;
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                noOfProvinces++;
                dfs(graph, visited, i);
            }
        }
        return noOfProvinces;
    }
}