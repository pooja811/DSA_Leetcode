class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if(rows == 1)
            return encodedText;

        int len = encodedText.length();

        if(len == 0)
            return encodedText;

        int cols = (int) Math.ceil( (double) len/rows);

        char[][] matrix = new char[rows][cols];
        char[] encodedArr = encodedText.toCharArray();
        int e=0;

        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                matrix[i][j] = encodedArr[e++];
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int startCol = 0; startCol < cols; startCol++) {
            int r = 0;
            int c = startCol;

            while (r < rows && c < cols) {
                sb.append(matrix[r][c]);
                r++;
                c++;
            }
        }

        return sb.toString().stripTrailing();
    }
}