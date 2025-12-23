import java.util.Scanner;
class LeetCode37 {
    static boolean isSolved = false;
    public static boolean rowCheck(char[][] board, int i, int j) {
        int count = 0;
        char val = board[i][j];
        for(int k=0;k<board.length;k++) {
            if(board[k][j] == val) count++;
        }
        return count==1;
    }
    public static boolean colCheck(char[][] board, int i, int j) {
        int count = 0;
        char val = board[i][j];
        for(int k=0;k<board[0].length;k++) {
            if(board[i][k] == val) count++;
        }
        return count==1;
    }
    public static boolean boxCheck(char[][] board, int i, int j) {
        int noOfRows = board.length, noOfCols = board[0].length;
        int boxRows = (int) Math.sqrt(noOfRows), boxCols = (int) Math.sqrt(noOfCols);
        int count = 0, rowStart = (i/boxRows)*boxRows, colStart = (j/boxCols)*boxCols;
        char val = board[i][j];
        for(int a=rowStart; a< (rowStart + boxRows); a++) {
            for(int b=colStart; b< (colStart + boxCols); b++) {
                if(board[a][b] == val) count++;
            }
        }
        return count==1;
    }
    public static boolean isValid(char[][] board, int i, int j) {
        return rowCheck(board,i,j) && colCheck(board,i,j) && boxCheck(board,i,j);
    }
    public static void displaySudokuBoard(char[][] board) {
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }
    public static void solve(char[][] board, int row, int col) {
        if(isSolved) return;
        if(row == board.length) {
            isSolved = true;
            return;
        }
        if(board[row][col] != '.') {
            if(col != board[0].length-1)
                solve(board,row,col+1);
            else
                solve(board,row+1,0);
        } else {
            for(char ch='1';ch<=(char)(board.length+48);ch++) {
                board[row][col] = ch;
                if(isValid(board, row, col)) {
                    if(col != board[0].length-1)
                        solve(board,row,col+1);
                    else
                        solve(board,row+1,0);
                    if(isSolved) return;
                    /* backtrack only when the board is not solved */
                    board[row][col] = '.';
                } else {
                    board[row][col] = '.';
                }
            }
        }
    }
    public static void solveSudoku(char[][] board) {
        solve(board,0,0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the dimension of the sudoku board: ");
        int n = sc.nextInt();
        if(Math.pow(Math.sqrt(n), 2)!= n) {
            System.out.println("Input dimension is not a valid sudoku board!");
            return;
        }
        char[][] board = new char[n][n];
        System.out.println("*---Enter the numbers already known (or '.' if unknown)---*");
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                System.out.print("Enter value at board[" + i + "][" + j + "]: ");
                board[i][j] = sc.next().charAt(0);
            }
            System.out.println();
        }
        solveSudoku(board);
        if(!LeetCode37.isSolved)
            System.out.println("No solution exists!");
        else {
            System.out.println("Solution: ");
            displaySudokuBoard(board);
        }
        LeetCode37.isSolved = false;
        sc.close();
    }
}
