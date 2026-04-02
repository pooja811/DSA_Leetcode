class Solution {
    int n, m;
    int[][][] dp;
    
    public int maximumAmount(int[][] coins) {
        n = coins.length;
        m = coins[0].length;
        dp = new int[n][m][3];
        
        // Base case: Reaching the end with 2 abilities used. 
        // (Other states implicitly handle the logic by returning 0 or funneling to max)
        dp[n-1][m-1][2] = coins[n-1][m-1];
        
        for(int i = n-1; i >= 0; i--){
            for(int j = m-1; j >= 0; j--){
                if(i == n-1 && j == m-1) continue;
                
                for(int ability = 2; ability >= 0; ability--){
                    int ans = (int)-1e9; // Start with a very small number
                    
                    // Choice 1: Take the coin normally
                    if(i < n-1) ans = Math.max(ans, coins[i][j] + dp[i+1][j][ability]);
                    if(j < m-1) ans = Math.max(ans, coins[i][j] + dp[i][j+1][ability]);
                    
                    // Choice 2: Neutralize the robber (add 0 instead of negative coin)
                    if(coins[i][j] < 0 && ability < 2){
                        if(i < n-1) ans = Math.max(ans, dp[i+1][j][ability+1]);
                        if(j < m-1) ans = Math.max(ans, dp[i][j+1][ability+1]);
                    }
                    
                    dp[i][j][ability] = ans;
                }
            }
        }
        
        // The answer could come from a path that used 0, 1, or 2 abilities along the way
        return Math.max(dp[0][0][0], Math.max(dp[0][0][1], dp[0][0][2]));
    }
}