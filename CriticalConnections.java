import java.util.*;
class CriticalConnections {
    public static int timer = 1; /* this will track the current time */
    public static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int[] dt, int[] low, List<List<Integer>> bridges, int src, int parent) {
        visited[src] = true;
        dt[src] = low[src] = timer++;
        for (int i=0; i<graph.get(src).size(); i++) {
            int curr_neighbor = graph.get(src).get(i);
            if (curr_neighbor != parent) {
                if (!visited[curr_neighbor]) {
                    /* Since the current neighbor is not visited, we explore it using DFS. After returning, we check whether this edge can act as a bridge */
                    dfs(graph, visited, dt, low, bridges, curr_neighbor, src);
                    low[src] = Math.min(low[src], low[curr_neighbor]);
                    if (low[curr_neighbor] > dt[src]) {
                        /* this means the lowest possible time to reach the neighbor is more than the discovery time of src, so there is no alternative path connecting them except this edge. Hence, this edge is a bridge */
                        ArrayList<Integer> curr_bridge = new ArrayList<>();
                        curr_bridge.add(src);
                        curr_bridge.add(curr_neighbor);
                        bridges.add(curr_bridge);
                    }
                } else {
                    /* This means the neighbor is already visited and is not the parent. This shows that from the current node, we can reach an earlier visited node using a different path without going back through the parent edge. For example, while moving forward step by step, sometimes we suddenly find a road that goes back to a place we have already reached earlier, but not through the road we just came from. This means there is another way to reach that earlier place. Because of this extra route, removing the current road will not break the connection between places. That is why this road cannot be a critical one, and we only update the earliest time we can reach from here. Now back to the question of consideration of this edge, even if the current edge is removed, the nodes are still connected. Hence, we update the low time using the discovery time of that neighbor */
                    low[src] = Math.min(low[src], dt[curr_neighbor]);
                }
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i=0; i<n; i++)
            graph.add(new ArrayList<>());

        /* Building the arraylist of edges */
        for (List<Integer> conn : connections) {
            int src = conn.get(0);
            int dest = conn.get(1);
            graph.get(src).add(dest);
            graph.get(dest).add(src);
            /* We are adding both as this is an undirected graph */
        }

        boolean[] visited = new boolean[n]; /* visited array to track the nodes visited */
        int[] dt = new int[n]; /* to track the discovery time of the nodes */
        int[] low = new int[n]; /* to track the lowest time required to reach the node */
        List<List<Integer>> bridges = new ArrayList<>(); /* stores the bridges */

        for(int i=0; i<n; i++) {
            if (!visited[i]) {
                dfs(graph, visited, dt, low, bridges, i, -1); /* The vertex for which we call dfs in this loop is the starting vertex for every new connected component, and the starting vertex has no parent. Hence, we pass -1 as its parent */
            }
        }
        return bridges;
    }
}