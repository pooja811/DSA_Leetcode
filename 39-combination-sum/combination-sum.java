class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();
        solve(candidates, target, 0, pos, ans);
        return ans;
    }

    public void solve(int[] arr, int t, int ind, List<Integer> pos, List<List<Integer>> ans) {
        // base case
        if(ind == arr.length) {
            if(t == 0) ans.add(new ArrayList<>(pos));
            return;
        }

        // recurse
        if(arr[ind] <= t) {
            pos.add(arr[ind]);
            solve(arr, t - arr[ind], ind, pos, ans);
            // backtrack
            pos.remove(pos.size() - 1);
        }
        // if curr ele is greater than we want, skip to next ind
        solve(arr, t, ind + 1, pos, ans);
    }
}