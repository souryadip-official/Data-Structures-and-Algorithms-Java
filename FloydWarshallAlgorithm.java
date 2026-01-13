import java.util.Scanner;
public class FloydWarshallAlgorithm {
    public static int[][] shortestPath(int[][] costMatrix) {
        for (int via = 0; via < costMatrix.length; via++) {
            for (int row = 0; row < costMatrix.length; row++) {
                if (row == via) continue;
                for (int col = 0; col < costMatrix[0].length; col++) {
                    int currCost = costMatrix[row][col];
                    if (col == via) continue;
                    int rowToVia = costMatrix[row][via];
                    int viaToCol = costMatrix[via][col];
                    if (rowToVia == Integer.MAX_VALUE || viaToCol == Integer.MAX_VALUE)
                        continue; /* Integer.MAX_VALUE cannot be better than some other thing any way */
                    int newCost = rowToVia + viaToCol;
                    costMatrix[row][col] = Math.min(currCost, newCost);
                }
            }
        }
        return costMatrix;
    }

    public static void main(String[] args) {
        /* We are designing the code for directed graphs. If we are dealing with undirected graphs, just split the edge between i -- j as i --> j and j --> i */
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();
        int[][] costMatrix = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (i == j) {
                    costMatrix[i][j] = 0;
                    continue;
                }
                System.out.print("Cost of edge between vertices " + i +" and " + j + "? (type \"no\" if no edge exists) ");
                String val = sc.next().toLowerCase();
                if (val.equals("no"))
                    costMatrix[i][j] = Integer.MAX_VALUE; /* Unreachable state */
                else
                    costMatrix[i][j] = Integer.parseInt(val);
            }
        }
        for (int[] row: costMatrix) {
            for (int ele: row)
                System.out.print((ele == Integer.MAX_VALUE? "INF" : ele) + "\t\t");
            System.out.println();
        }

        int[][] minCostMatrix = shortestPath(costMatrix);
        System.out.println("\nShortest Path");
        for (int[] row: minCostMatrix) {
            for (int ele: row)
                System.out.print((ele == Integer.MAX_VALUE? "INF" : ele) + "\t\t");
            System.out.println();
        }
    }
}
