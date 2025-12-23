import java.util.*;
class Solution {
    public boolean isPresent(ArrayList<ArrayList<Integer>> lst, int idx, int val) {
        for (int i = 0; i < lst.get(idx).size(); i++) {
            if (lst.get(idx).get(i) == val) {
                return true;
            }
        }
        return false;
    }
    public void makeZeros(int[][] matrix, int row, int col) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[row][j] = 0;
        }
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }
    public void setZeroes(int[][] matrix) {
        ArrayList<ArrayList<Integer>> lst = new ArrayList<>();
        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> cols = new ArrayList<>();
        lst.add(rows);
        lst.add(cols);

        int i = 0, j = 0;
        for (i = 0; i < matrix.length; i++) {
            for (j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if(!isPresent(lst, 0, i)) lst.get(0).add(i);
                    if(!isPresent(lst, 1, j)) lst.get(1).add(j);
                }
            }
        }
        for (int r = 0; r < lst.get(0).size(); r++) {
            int currRow = lst.get(0).get(r);
            for (int c = 0; c < lst.get(1).size(); c++) {
                makeZeros(matrix, currRow, lst.get(1).get(c));
            }
        }
    }
}