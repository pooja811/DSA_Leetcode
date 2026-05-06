class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length, n = box[0].length;
        char[][] res = new char[n][m];

        // gravity
        for (int i = 0; i < m; i++) {
            int e = n - 1;// empty
            for (int j = n - 1; j >= 0; j--) {
                if (box[i][j] == '*') e = j - 1;
                else if (box[i][j] == '#') {
                    box[i][j] = '.';
                    box[i][e] = '#';
                    e--;
                }
            }
        }

        // rotate
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                res[j][m - i - 1] = box[i][j];

        return res;
    }
}