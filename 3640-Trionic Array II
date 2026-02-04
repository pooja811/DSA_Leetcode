class Solution {

    public long maxSumTrionic(int[] nums) {

        int n = nums.length;
        long ans = Long.MIN_VALUE;

        for (int i = 1; i < n - 2; i++) {

            int l = i;
            int r = i;

            long midSum = nums[i];

            while (r + 1 < n && nums[r + 1] < nums[r]) {
                midSum += nums[++r];
            }

            if (r == i) continue;

            int midEnd = r;

            long bestL = Long.MIN_VALUE;
            long bestR = Long.MIN_VALUE;

            long curL = 0;
            long curR = 0;

            while (l - 1 >= 0 && nums[l - 1] < nums[l]) {
                curL += nums[--l];
                bestL = Math.max(bestL, curL);
            }

            if (l == i) continue;

            while (r + 1 < n && nums[r + 1] > nums[r]) {
                curR += nums[++r];
                bestR = Math.max(bestR, curR);
            }

            if (r == midEnd) continue;

            i = r - 1;
            ans = Math.max(ans, bestL + midSum + bestR);
        }

        return ans;
    }
}
