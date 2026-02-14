class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] pyramid = new double[query_row + 2][query_row + 2];
        pyramid[0][0] = (double)poured;
        for(int i = 0; i <= query_row; i++){
            for(int j = 0; j <= i; j++){
                if(pyramid[i][j] > 1.0){
                    double remain = pyramid[i][j] - 1.0;
                    pyramid[i + 1][j] += remain / 2;
                    pyramid[i + 1][j + 1] += remain / 2;
                    pyramid[i][j] = 1.0;
                }
            }
        }

        return pyramid[query_row][query_glass];
    }
}