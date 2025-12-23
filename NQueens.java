import java.util.Scanner;
public class NQueens {
    public static void displayBoard(char[][] board) {
        System.out.println("*-----ChessBoard-----*");
        for(int i=0;i< board.length;i++) {
            for(int j=0;j<board[0].length;j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }
    public static boolean checkVertical(char[][] board, int r, int c) {
        if(r == 0) return board[r][c] != 'Q';
        if(board[r][c] != 'Q')
            return checkVertical(board, r-1, c);
        return false;
    }
    public static boolean checkLeftDiagonal(char[][] board, int r, int c) {
        if(r == 0 || c == 0) return board[r][c] != 'Q';
        if(board[r][c] != 'Q')
            return checkLeftDiagonal(board, r-1, c-1);
        return false;
    }
    public static boolean checkRightDiagonal(char[][] board, int r, int c) {
        if(r == 0 || c == board[0].length-1)
            return board[r][c] != 'Q';
        if(board[r][c] != 'Q')
            return checkRightDiagonal(board, r-1, c+1);
        return false;
    }
    public static boolean isSafe(char[][] board, int r, int c) {
        return checkVertical(board,r,c) && checkLeftDiagonal(board,r,c) && checkRightDiagonal(board,r,c);
        /* Here, we have used recursive approach to check isSafe. We can also adopt iterative methods to do the same */
    }

    /**
     * This function takes a char 2d array (chessboard) and the starting index and prints all the possible solution if exists for a particular board size
     * @param board: Chessboard (char[][] array)
     * @param r: Starting row
     */
    public static void place_NQueens(char[][] board, int r) {
        if(r == board.length) {
            displayBoard(board);
            return;
        }
        for(int j=0;j<board[0].length;j++) {
            if(isSafe(board,r,j)) {
                board[r][j] = 'Q';
                place_NQueens(board, r+1);
                board[r][j] = 'x';
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the board (n): ");
        int n = sc.nextInt();
        char[][] board = new char[n][n];
        /* Initialising an empty chessboard */
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                board[i][j] = 'x';
        place_NQueens(board, 0);
        /* if(place_NQueens(board, 0)) {
            System.out.println("Solution is possible!");
            displayBoard(board);
        }
        else System.out.println("No solution exists."); */
        sc.close();
    }
}
