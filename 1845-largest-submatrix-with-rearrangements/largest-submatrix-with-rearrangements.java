class Solution {
    public int largestSubmatrix(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;

        for (int r = 0; r < rows; r++) {

            // Build height histogram (as shown in first diagram)
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1 && r > 0) {
                    grid[r][c] = grid[r][c] + grid[r - 1][c];
                }
            }

            // Copy heights for sorting (simulate column rearrangement)
            int[] heights = new int[cols];
            for (int i = 0; i < cols; i++) {
                heights[i] = grid[r][i];
            }

            // Sort heights (like "Sorted Heights" diagram)
            Arrays.sort(heights);

            // Compute max area (right → left)
            for (int i = cols - 1; i >= 0; i--) {
                int width = cols - i; // number of columns used
                int area = heights[i] * width;

                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }

        return maxArea;
    }
}