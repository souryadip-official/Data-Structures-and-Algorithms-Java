class LeetCode36 {
    public static boolean rowCheck(char[][] board, int i, int j) {
        int count = 0, val = board[i][j];
        for(int k=0;k<board.length;k++) {
            if(board[k][j] == val)
                count++;
        }
        return count==1;
    }
    public static boolean colCheck(char[][] board, int i, int j) {
        int count = 0, val = board[i][j];
        for(int k=0;k<board[0].length;k++) {
            if(board[i][k] == val)
                count++;
        }
        return count==1;
    }
    public static boolean boxCheck(char[][] board, int i, int j) {
        int count = 0, val = board[i][j], rowStart = (i/3)*3, colStart = (j/3)*3;
        for(int a=rowStart;a<rowStart+3;a++) {
            for(int b=colStart;b<colStart+3;b++) {
                if(board[a][b] == val)
                    count++;
            }
        }
        return count==1;
    }
    public static boolean isValid(char[][] board, int i, int j) {
        return rowCheck(board,i,j) && colCheck(board,i,j) && boxCheck(board,i,j);
    }
    public static boolean isValidSudoku(char[][] board) {
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j] != '.') {
                    if(!isValid(board,i,j))
                        return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        if (isValidSudoku(board))
            System.out.println("The Sudoku board is valid.");
        else
            System.out.println("The Sudoku board is NOT valid.");
    }

}