class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        long total = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                total += grid[i][j];
            }
        }

        int[][] currentGrid = grid;
        for (int r = 0; r < 4; r++) {
            Set<Long> visited = new HashSet<>();
            visited.add(0L);
            long vals = 0;
            int rLen = currentGrid.length;
            int cLen = currentGrid[0].length;

            if (rLen < 2) {
                currentGrid = rotation(currentGrid);
                continue;
            }

            if (cLen == 1) {
                for (int i = 0; i < rLen - 1; i++) {
                    vals += currentGrid[i][0];
                    long flag = vals * 2 - total;
                    if (flag == 0 || flag == currentGrid[0][0] || flag == currentGrid[i][0]) {
                        return true;
                    }
                }
            } else {
                for (int i = 0; i < rLen - 1; i++) {
                    for (int j = 0; j < cLen; j++) {
                        visited.add((long) currentGrid[i][j]);
                        vals += currentGrid[i][j];
                    }
                    long flag = vals * 2 - total;
                    if (i == 0) {
                        if (flag == 0 || flag == currentGrid[0][0] || flag == currentGrid[i][cLen - 1]) {
                            return true;
                        }
                    } else if (visited.contains(flag)) {
                        return true;
                    }
                }
            }
            currentGrid = rotation(currentGrid);
        }
        return false;
    }

    private int[][] rotation(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] tmp = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                tmp[j][rows - 1 - i] = grid[i][j];
            }
        }
        return tmp;
    }
}