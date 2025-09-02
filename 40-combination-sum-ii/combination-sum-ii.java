class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort to handle duplicates and enable pruning
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> path, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Skip duplicates
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            // Prune branches where candidate exceeds target
            if (candidates[i] > target) break;

            path.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, path, result); // i + 1 ensures each number is used once
            path.remove(path.size() - 1); // Backtrack
        }
    }
}