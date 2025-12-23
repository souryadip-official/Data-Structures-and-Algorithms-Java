import java.util.Scanner;
public class RatInAMaze {
    static int pathCount = 0;
    public static int findRatWays(int[][] grid, int row, int col, int dim, boolean[][] visited, String path) {
        /* Out of boundary condition */
        if(row == dim || row == -1 || col == dim || col == -1 || grid[row][col] == 0 || visited[row][col]) return 0;
        /* in case we are already at destination */
        else if(row == dim-1 && col == dim-1) {
            System.out.println("Path " + (++pathCount) + ": " + path);
            return 1;
        }
        /* The visited array is maintained so that the rat does not keep on routing in a circle and hence ensure that every time a new move is taken without just circling around a path */
        visited[row][col] = true;
        /* taking the left move */
        int leftWays = findRatWays(grid,row,col-1,dim, visited,path + "Left ");
        /* taking the right move */
        int rightWays = findRatWays(grid,row,col+1,dim, visited,path + "Right ");
        /* taking the up move */
        int upWays = findRatWays(grid,row-1,col,dim, visited,path + "Up ");
        /* taking the down move */
        int downWays = findRatWays(grid,row+1,col,dim, visited,path + "Down ");
        visited[row][col] = false;
        /* Backtracking */
        return leftWays + rightWays + upWays + downWays;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter grid dimensions (n): ");
        int n = sc.nextInt();
        if(n == 1) {
            System.out.println("Source and destination cells are same. No moves required!");
            return;
        }
        int[][] grid = new int[n][n];
        System.out.println("Enter whether the cell is block or not (0 if block, 1 if open)");
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                if((i == 0 && j == 0) || (i == n-1 && j == n-1)) {
                    System.out.println("Source and destination must be free!");
                    grid[i][j] = 1;
                    continue;
                }
                System.out.print("Enter status of cell [" + i + "][" + j + "]: ");
                grid[i][j] = sc.nextInt();
            }
            System.out.println();
        }
        boolean[][] visited = new boolean[n][n];
        int res = findRatWays(grid, 0,0,n, visited, "");
        if(res == 0) System.out.println("No solution exists!");
        else System.out.println("Total ways: " + res);
        sc.close();
    }
}
