import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class LeetCode51 {
    /* we only check upwards because queens are placed row by row from top to bottom */
    public static boolean checkVertical(String[][] board, int r, int c) {
        if(r == 0) return !board[r][c].equals("Q");
        if (!board[r][c].equals("Q"))
            return checkVertical(board, r-1, c);
        return false;
    }
    /* checks the upper-left diagonal since any attacking queen must already be placed in previous rows */
    public static boolean checkLeftDiag(String[][] board, int r, int c) {
        if (r == 0 || c == 0) return !board[r][c].equals("Q");
        if (!board[r][c].equals("Q"))
            return checkLeftDiag(board, r-1, c-1);
        return false;
    }
    /* checks the upper-right diagonal, same logic: only previous rows can have queens */
    public static boolean checkRightDiag(String[][] board, int r, int c) {
        if (r == 0 || c == board[0].length-1) return !board[r][c].equals("Q");
        if (!board[r][c].equals("Q"))
            return checkRightDiag(board, r-1, c+1);
        return false;
    }
    /* a cell is safe only if column, left diagonal and right diagonal are all safe */
    public static boolean isSafe(String[][] board, int r, int c) {
        return checkVertical(board, r, c) && checkLeftDiag(board, r, c) && checkRightDiag(board, r, c);
    }
    /* backtracking function: try to place a queen row by row and build solutions */
    public static void solveNQueensUtil(int r, String[][] board, List<List<String>> finalRes) {
        if (r == board.length) {
            /* all rows are filled, so current board is one valid solution */
            List<String> ans = new ArrayList<>();
            for(int i=0; i<board.length; i++) {
                StringBuilder str = new StringBuilder();
                for(int j=0; j<board[0].length; j++) {
                    str.append(board[i][j]);
                }
                ans.add(str.toString());
            }
            finalRes.add(ans);
            return;
        }
        /* try placing a queen in every column of the current row */
        for(int j=0; j<board[0].length; j++) {
            if (isSafe(board, r, j)) {
                board[r][j] = "Q"; /* place queen */
                solveNQueensUtil(r+1, board, finalRes); /* move to next row */
                board[r][j] = "."; /* backtrack: remove queen and try next position */
            }
        }
    }
    /* initializes the board and starts backtracking from row 0 */
    public List<List<String>> solveNQueens(int n) {
        String[][] board = new String[n][n];
        for(int i=0; i<board.length; i++)
            Arrays.fill(board[i], ".");

        List<List<String>> finalRes = new ArrayList<>();
        solveNQueensUtil(0, board, finalRes);
        return finalRes;
    }
}