class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int value = sum / 2;
        boolean dp[] = new boolean[value + 1];
        dp[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = value; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[value];
    }
}