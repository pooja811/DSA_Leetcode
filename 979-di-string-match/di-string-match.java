class Solution {

    public int[] diStringMatch(String S) {
        int n = S.length();
        int l = 0, r = n;
        int[] ans = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            if (S.charAt(i) == 'I') ans[i] = l++;
            else ans[i] = r--;
        }

        ans[n] = l;
        return ans;
    }
}