import java.util.Arrays;
public class CityWithSmallestNeighborsWithThresholdDistance {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] costMatrix = new int[n][n];
        for (int[] arr: costMatrix)
            Arrays.fill(arr, Integer.MAX_VALUE);

        for (int i=0; i<n; i++)
            costMatrix[i][i] = 0;

        for (int i=0; i<edges.length; i++) {
            int[] currEdge = edges[i];
            int from = currEdge[0];
            int to = currEdge[1];
            int wt = currEdge[2];
            costMatrix[from][to] = wt;
            costMatrix[to][from] = wt; /* Since the graph is undirected */
        }

        for (int via=0; via<n; via++) {
            for (int row=0; row<n; row++) {
                if (row == via) continue;
                for (int col=0; col<n; col++) {
                    int currCost = costMatrix[row][col];
                    if (col == via) continue;
                    int rowToVia = costMatrix[row][via];
                    int viaToCol = costMatrix[via][col];
                    if (rowToVia == Integer.MAX_VALUE || viaToCol == Integer.MAX_VALUE)
                        continue;
                    int newCost = rowToVia + viaToCol;
                    costMatrix[row][col] = Math.min(currCost, newCost);
                }
            }
        }

        int minIdx = -1;
        int minCount = Integer.MAX_VALUE;
        for (int i=0; i<n; i++) {
            int count = 0;
            for (int j=0; j<n; j++) {
                if (i == j) continue;
                if (costMatrix[i][j] <= distanceThreshold)
                    count++;
            }
            if (count <= minCount) {
                minCount = count;
                minIdx = i;
            }
        }
        return minIdx;
    }
}