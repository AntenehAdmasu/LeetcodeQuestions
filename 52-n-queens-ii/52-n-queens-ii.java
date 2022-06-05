// To be REDONE
class Solution {
    int result = 0;
    public int totalNQueens(int n) {
        boolean[] columns = new boolean[n];
        boolean[] diagonal1 = new boolean[2 * n - 1];
        boolean[] diagonal2 = new boolean[2 * n - 1];
        helper(0, n, columns, diagonal1, diagonal2);
        return result;
    }
    private void helper(int row, int n, boolean[] columns, boolean[] diagonal1, boolean[] diagonal2) {
        if (row == n) {
            result++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (!columns[col] && !diagonal1[col + row] && !diagonal2[n - 1- row + col]) {
                columns[col] = diagonal1[col + row] = diagonal2[n - 1- row + col] = true;
                helper(row + 1, n, columns, diagonal1, diagonal2);
                columns[col] = diagonal1[col + row] = diagonal2[n - 1- row + col] = false;
            }
        }
    }
}