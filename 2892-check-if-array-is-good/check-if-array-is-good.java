class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<Integer> expected = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            expected.add(i);
        }
        expected.add(n - 1);
        for (int i = 0; i < n; i++) {
            if (nums[i] != expected.get(i)) {
                return false;
            }
        }
        return true;
    }
}