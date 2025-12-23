import java.util.Scanner;
public class KnightsTour113 {
    public static void displayboard(int[][] board) {
        int n = board.length;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++)
                System.out.print(board[i][j] + "\t");
            System.out.println();
        }
    }
    static boolean isSolved = false;
    public static void knights_tour(int[][] board, int row, int col, int idx) {
        int n = board.length;
        if(idx == (n * n)) {
            isSolved = true;
            displayboard(board);
            System.out.println();
            return;
        }
        /* if this cell is already visited */
        if(row < 0 || row >= n || col < 0 || col >= n || board[row][col] != -1) return;
        /* if not, we have 8 possible moves to make */
        board[row][col] = idx;
        /* Move 1: Taking the up-left move */
        if(!isSolved) knights_tour(board, row-2, col-1, idx+1);
        /* Move 2: Taking the up-right move */
        if(!isSolved) knights_tour(board, row-2, col+1, idx+1);

        /* Move 3:  Taking the left-up move */
        if(!isSolved) knights_tour(board, row-1, col-2, idx+1);

        /* Move 4: Taking the right-up move */
        if(!isSolved) knights_tour(board, row-1, col+2, idx+1);

        /* Move 5: Taking the down-right move */
        if(!isSolved) knights_tour(board, row+2, col+1, idx+1);

        /* Move 6: Taking the down-left move */
        if(!isSolved) knights_tour(board, row+2, col-1, idx+1);

        /* Move 7: Taking the left-down move */
        if(!isSolved) knights_tour(board, row+1, col-2, idx+1);

        /* Move 8: Taking the right-down move */
        if(!isSolved) knights_tour(board, row+1, col+2, idx+1);
        if(isSolved) return;
        board[row][col] = -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter chessboard dimension (n): ");
        int n = sc.nextInt();
        int[][] board = new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++) board[i][j] = -1;
        knights_tour(board,0,0,0);
        if(!isSolved)
            System.out.println("No Knight's Tour exists for n = " + n);
        sc.close();
    }
}
