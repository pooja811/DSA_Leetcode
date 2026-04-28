class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> arr = new ArrayList<>();

        // flatten grid
        for(int[] row : grid){
            for(int v : row){
                arr.add(v);
            }
        }

        // check divisibility
        int base = arr.get(0);
        for(int v : arr){
            if(Math.abs(v - base) % x != 0)
                return -1;
        }

        // sort
        Collections.sort(arr);

        // median
        int median = arr.get(arr.size()/2);

        // count operations
        int ops = 0;
        for(int v : arr){
            ops += Math.abs(v - median) / x;
        }

        return ops;
    }
}