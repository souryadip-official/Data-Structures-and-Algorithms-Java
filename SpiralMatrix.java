import java.util.ArrayList;
import java.util.List;
public class SpiralMatrix {
    public static void spiralOrderUtil(int[][] matrix, boolean[][] visited, List<Integer> ans, int r, int c, int cameFrom) {
        if (visited[r][c]) return; /* Stop recursion if this cell was already processed */
        if (cameFrom == 1) { /* If we arrived here by moving upward, continue upward sweep */
            int lastValidRow = -1; /* Stores last valid row before hitting boundary/visited cell */
            while (r > 0 && !visited[r][c]) { /* Walk upward in the same column */
                visited[r][c] = true; /* Mark current cell as visited */
                ans.add(matrix[r][c]); /* Add current element to spiral order */
                lastValidRow = r; /* Remember last valid row for restoring position */
                r = r - 1; /* Move one step upward */
            }
            r = lastValidRow; /* Restore row to last valid position for correct next move */
        } else {
            visited[r][c] = true; /* Mark current cell as visited */
            ans.add(matrix[r][c]); /* Add current element to spiral order */
        }
        int nr, nc, dir; /* nr, nc are next row and column; dir tracks movement direction */
        dir = 0; /* Default direction (0 = not coming from up) */
        if (c < matrix[0].length - 1 && !visited[r][c + 1]) { /* Try moving right */
            nr = r; /* Row remains same */
            nc = c + 1; /* Move to next column */
        }
        else if (r < matrix.length - 1 && !visited[r + 1][c]) { /* Try moving down */
            nr = r + 1; /* Move to next row */
            nc = c; /* Column remains same */
        }
        else if (c > 0 && !visited[r][c - 1]) { /* Try moving left */
            nr = r; /* Row remains same */
            nc = c - 1; /* Move to previous column */
        }
        else if (r > 0 && !visited[r - 1][c]) { /* Try moving up */
            nr = r - 1; /* Move to previous row */
            nc = c; /* Column remains same */
            dir = 1; /* Mark that the next call is coming from an upward direction */
        }
        else return; /* No valid moves left: spiral traversal is complete */
        spiralOrderUtil(matrix, visited, ans, nr, nc, dir); /* Recurse to next cell */
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length]; /* Track visited cells */
        List<Integer> ans = new ArrayList<>(); /* Store spiral traversal result */
        spiralOrderUtil(matrix, visited, ans, 0, 0, 0); /* Start traversal from top-left corner */
        return ans; /* Return final spiral order */
    }
}