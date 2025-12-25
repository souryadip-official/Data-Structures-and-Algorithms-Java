import java.util.*;
public class ArticulationPoints {
    public static int timer = 1; /* This timer is used to assign discovery times to vertices and increases whenever a new vertex is visited in DFS */

    public static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int[] dt, int[] low, boolean[] mark, int src, int parent) {
        visited[src] = true; /* Mark the current vertex as visited so it is not processed again */
        dt[src] = low[src] = timer++; /* Assign discovery time to the vertex and initialize low value with the same time */

        int child = 0; /* Counts how many DFS children this vertex has; mainly used for deciding articulation point in case of root */

        for (int i = 0; i < graph.get(src).size(); i++) {
            int curr_neighbor = graph.get(src).get(i); /* Fetch the adjacent vertex */

            if (curr_neighbor != parent) { /* Ignore the edge leading back to the parent to avoid trivial cycle */
                if (!visited[curr_neighbor]) { /* If the neighbor is not visited, this edge becomes a DFS tree edge */
                    dfs(graph, visited, dt, low, mark, curr_neighbor, src); /* Explore the neighbor using DFS */

                    low[src] = Math.min(low[src], low[curr_neighbor]);
                    /* After returning from DFS, update low[src] using low value of child to know the earliest reachable ancestor */

                    if (low[curr_neighbor] > dt[src] && parent != -1) {
                        /* If the child cannot reach any ancestor of src, and src is not the root,
                           then removing src will disconnect the child subtree, so src is an articulation point */
                        mark[src] = true;
                    }

                    child++;
                    /* Increment child count only when a DFS call is made.
                       This ensures we count only DFS tree children and not back edges */
                } else {
                    /* This means the neighbor is already visited and is not the parent.
                       So, this edge is a back edge which gives an alternate path */
                    low[src] = Math.min(low[src], dt[curr_neighbor]);
                    /* Update low[src] using discovery time of the neighbor,
                       because dt is guaranteed and low of neighbor may still change */
                }
            }
        }
        /* Special case for root vertex: if it has more than one DFS child, then it is an articulation point since it connects multiple independent subtrees */
        if (child > 1 && parent == -1)
            mark[src] = true;
        /* For articulation point detection, the logic differs for root and non-root vertices. For a non-root vertex, if there exists a child such that the lowest discovery time reachable from that child (low[child]) is strictly greater than the discovery time of the current vertex (dt[src]), then removing the current vertex will disconnect that child’s subtree from the rest of the graph, making the current vertex an articulation point. However, for the root vertex (parent == -1), this condition does not apply. The root is an articulation point only if it has more than one DFS child, because multiple DFS children indicate that the root is the only connection between those independent subtrees. Hence, we explicitly count DFS children for the root and mark it only when childCount > 1. */
    }

    public ArrayList<Integer> articulationPoints(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); /* Create adjacency list representation of the graph */
        /* Initialize an adjacency list for all vertices */
        for (int i = 0; i < V; i++)
            graph.add(new ArrayList<>());


        for (ArrayList<Integer> conn : adj) {
            int src = conn.get(0);
            int dest = conn.get(1);
            graph.get(src).add(dest);
            graph.get(dest).add(src);
            /* Add edges in both directions since the graph is undirected */
        }

        boolean[] visited = new boolean[V]; /* Keeps track of visited vertices */
        int[] dt = new int[V]; /* Stores discovery time of each vertex */
        int[] low = new int[V]; /* Stores lowest discovery time reachable from each vertex */
        boolean[] mark = new boolean[V]; /* Marks vertices which are articulation points */

        ArrayList<Integer> articulationpts = new ArrayList<>(); /* Stores final list of articulation points */

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(graph, visited, dt, low, mark, i, -1);
                /* Run DFS for every unvisited vertex to handle disconnected components */
            }
        }

        for (int i = 0; i < mark.length; i++) {
            if (mark[i]) articulationpts.add(i); /* Collect all vertices marked as articulation points */
        }

        if (articulationpts.isEmpty()) /* If no articulation point exists in the graph */
            articulationpts.add(-1);

        return articulationpts; /* Return the list of articulation points */
    }
}
