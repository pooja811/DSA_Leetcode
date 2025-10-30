class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0, j = n - 1;  // start from top-right corner
        while (i < m && j >= 0) {
            if (matrix[i][j] == target)
                return true;
            else if (matrix[i][j] > target)
                j--; // move left
            else
                i++; // move down
        }
        return false;
    }
}