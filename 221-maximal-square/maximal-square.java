class Solution {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int result = 0;
        int array[] = new int[col+1];
        int tmp = 0;
        int prev = 0;
        for(int i=1;i<=row;i++){
            prev = 0;
            for(int j=1;j<=col;j++){
                if(matrix[i-1][j-1]=='1'){
                    tmp = array[j];
                    array[j]=Math.min(Math.min(array[j-1], array[j]),prev)+1;
                    prev = tmp;
                result = Math.max(result, array[j]);
                }else{
                    prev = array[j];
                    array[j] = 0;
                }
            }
        }
        return result*result;
    }
}