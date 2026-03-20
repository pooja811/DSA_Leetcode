class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] result = new int[n-k+1][m-k+1];
        if(k==1)return result;
        for(int i=0; i<n-k+1; i++){
            for(int j=0; j<m-k+1; j++){
                int[] arr = new int[k*k];
                int idx=0;
                for(int start =i; start<i+k; start++){
                    for(int end = j; end<j+k; end++){
                        arr[idx++]=grid[start][end];
                    }
                }
                Arrays.sort(arr);
                int min=Integer.MAX_VALUE;
                for(int l=1; l<k*k; l++){
                    if(arr[l]!=arr[l-1]){
                     min  = Math.min(min,Math.abs(arr[l]-arr[l-1]));                       
                    }

                }
                if (min == Integer.MAX_VALUE) {
                    min = 0;
                }
                result[i][j]=min;
            }
        }
        return result;
    }
}